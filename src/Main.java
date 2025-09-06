import ast.*;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import parser.MiniCLexer;
import parser.MiniCParser;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_CYAN = "\u001B[36m";

    public static void main(String[] args) {
        // حالت اول: مبهم کردن فایل‌های اصلی
        for (int i = 1; i <= 5; i++) {
            try {
                String inputFile = "input" + i + ".mc";
                if (!Files.exists(Paths.get(inputFile))) {
                    continue;
                }

                obfuscateFile(inputFile, "output" + i + ".mc");
            } catch (Exception e) {
                System.out.println("Error processing input" + i + ".mc: " + e.getMessage());
            }
        }

        // حالت دوم: غیر مبهم کردن فایل‌های مبهم شده
        for (int i = 1; i <= 5; i++) {
            try {
                String obfuscatedInputFile = "obfuscated" + i + ".mc";
                if (!Files.exists(Paths.get(obfuscatedInputFile))) {
                    continue;
                }

                deobfuscateFile(obfuscatedInputFile, "cleaned" + i + ".mc");
            } catch (Exception e) {
                System.out.println("Error processing obfuscated" + i + ".mc: " + e.getMessage());
            }
        }
    }

    private static void obfuscateFile(String inputFile, String outputFile) throws IOException {
        String code = new String(Files.readAllBytes(Paths.get(inputFile)));

        // Parse tree
        CharStream input = CharStreams.fromString(code);
        MiniCLexer lexer = new MiniCLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        MiniCParser parser = new MiniCParser(tokens);
        ParseTree tree = parser.program();

        // AST from parse tree
        ASTBuilderVisitor astBuilder = new ASTBuilderVisitor();
        ProgramNode ast = (ProgramNode) astBuilder.visit(tree);
        if (ast == null) {
            System.out.println("AST is null for " + inputFile);
            return;
        }

        // Obfuscation
        ObfuscatorVisitor obfuscator = new ObfuscatorVisitor();
        String obfuscated = ast.accept(obfuscator);
        try (PrintWriter out = new PrintWriter(outputFile)) {
            out.println(obfuscated);
        }
        System.out.println(ANSI_GREEN + "Obfuscation complete: " + inputFile + " → " + outputFile + ANSI_RESET);
    }

    private static void deobfuscateFile(String obfuscatedInputFile, String cleanedOutputFile) throws IOException {
        String code = new String(Files.readAllBytes(Paths.get(obfuscatedInputFile)));

        // Parse tree
        CharStream input = CharStreams.fromString(code);
        MiniCLexer lexer = new MiniCLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        MiniCParser parser = new MiniCParser(tokens);
        ParseTree tree = parser.program();

        // AST from parse tree
        ASTBuilderVisitor astBuilder = new ASTBuilderVisitor();
        ProgramNode ast = (ProgramNode) astBuilder.visit(tree);
        if (ast == null) {
            System.out.println("AST is null for " + obfuscatedInputFile);
            return;
        }

        // Deobfuscation
        DeObfuscatorVisitor deobfuscator = new DeObfuscatorVisitor();
        ProgramNode deobfuscatedAST = (ProgramNode) deobfuscator.visit(ast);
        CodeGeneratorVisitor codeGenerator = new CodeGeneratorVisitor();
        String cleanedCode = deobfuscatedAST.accept(codeGenerator);
        try (PrintWriter out = new PrintWriter(cleanedOutputFile)) {
            out.println(cleanedCode);
        }
        System.out.println(ANSI_CYAN + "Deobfuscation complete: " + obfuscatedInputFile + " → " + cleanedOutputFile + ANSI_RESET);
    }
}