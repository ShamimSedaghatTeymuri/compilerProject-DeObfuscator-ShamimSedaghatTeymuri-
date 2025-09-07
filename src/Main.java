import ast.ASTBuilderVisitor;
import ast.CodeGeneratorVisitor;
import ast.DeObfuscatorVisitor;
import ast.ObfuscatorVisitor;
import ast.ProgramNode;
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
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_CYAN = "\u001B[36m";

    public static void main(String[] args) {
        int n = 5;
        // phase 1
        System.out.println(ANSI_CYAN + "===phase 1: obfuscation===" + ANSI_RESET);
        for (int i = 1; i <= n; i++) {
            try {
                String inputFile = "input" + i + ".mc";
                String outputFile = "output" + i + ".mc";
                String inputC = "input" + i + ".c";
                String outputC = "output" + i + ".c";

                // reading code
                String code = new String(Files.readAllBytes(Paths.get(inputFile)));

                // AST making
                CharStream input = CharStreams.fromString(code);
                MiniCLexer lexer = new MiniCLexer(input);
                CommonTokenStream tokens = new CommonTokenStream(lexer);
                MiniCParser parser = new MiniCParser(tokens);
                ParseTree tree = parser.program();

                ASTBuilderVisitor astBuilder = new ASTBuilderVisitor();
                ProgramNode ast = (ProgramNode) astBuilder.visit(tree);

                if (ast == null) {
                    System.out.println("AST is null for " + inputFile);
                    continue;
                }

                // obfuscation
                ObfuscatorVisitor obfuscator = new ObfuscatorVisitor();
                String obfuscatedCode = ast.accept(obfuscator);

                try (PrintWriter out = new PrintWriter(outputFile)) {
                    out.println(obfuscatedCode);
                }
                System.out.println(ANSI_GREEN + "\nobfuscation completed for : " + inputFile + ANSI_RESET);

                // comparing
                String originalCCode = "#include <stdio.h>\n" + code;
                Files.writeString(Paths.get(inputC), originalCCode);

                String obfuscatedCCode = "#include <stdio.h>\n" + obfuscatedCode;
                Files.writeString(Paths.get(outputC), obfuscatedCCode);

                System.out.println(ANSI_YELLOW + "comparing for phase 1: " + ANSI_RESET);
                PerformanceComparator.compare(inputC, outputC);

            } catch (IOException e) {
                System.out.println("error in reading " + "input" + i + ".mc: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("error in processing " + "input" + i + ".mc: " + e.getMessage());
                e.printStackTrace();
            }
        }

        //phase 2
        System.out.println(ANSI_CYAN + "=== phase 2: deobfuscation ===" + ANSI_RESET);
        for (int i = 1; i <= n; i++) {
            try {
                String obfuscatedFile = "obfuscated" + i + ".mc";
                String cleanedFile = "cleaned" + i + ".mc";
                String obfuscatedC = "obfuscated" + i + ".c";
                String cleanedC = "cleaned" + i + ".c";

                // reading obfuscated code
                String obfuscatedCode = new String(Files.readAllBytes(Paths.get(obfuscatedFile)));

                // making ast
                CharStream input = CharStreams.fromString(obfuscatedCode);
                MiniCLexer lexer = new MiniCLexer(input);
                CommonTokenStream tokens = new CommonTokenStream(lexer);
                MiniCParser parser = new MiniCParser(tokens);
                ParseTree tree = parser.program();

                ASTBuilderVisitor astBuilder = new ASTBuilderVisitor();
                ProgramNode ast = (ProgramNode) astBuilder.visit(tree);

                if (ast == null) {
                    System.out.println("AST is null for " + obfuscatedFile);
                    continue;
                }

                // deobfuscating
                DeObfuscatorVisitor deobfuscator = new DeObfuscatorVisitor();
                ProgramNode deobfuscatedAst = (ProgramNode) deobfuscator.visit(ast);

                CodeGeneratorVisitor codeGenerator = new CodeGeneratorVisitor();
                String cleanedCode = deobfuscatedAst.accept(codeGenerator);

                try (PrintWriter out = new PrintWriter(cleanedFile)) {
                    out.println(cleanedCode);
                }
                System.out.println(ANSI_GREEN + "\ndeobfuscation completed for :" + obfuscatedFile + ANSI_RESET);

                //comparing
                String obfuscatedCCode = "#include <stdio.h>\n" + obfuscatedCode;
                Files.writeString(Paths.get(obfuscatedC), obfuscatedCCode);

                String cleanedCCode = "#include <stdio.h>\n" + cleanedCode;
                Files.writeString(Paths.get(cleanedC), cleanedCCode);

                System.out.println(ANSI_YELLOW + "comparing :" + ANSI_RESET);
                PerformanceComparator.compare(obfuscatedC, cleanedC);

            } catch (IOException e) {
                System.out.println("error in reading " + "obfuscated" + i + ".mc: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("error in processing " + "obfuscated" + i + ".mc: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }
}