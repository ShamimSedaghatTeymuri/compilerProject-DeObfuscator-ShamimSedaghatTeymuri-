import ast.ASTBuilderVisitor;
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
    public static void main(String[] args) {
        for (int i = 1; i <= 5; i++) {
            try {
                String inputFile = "input" + i + ".mc";
                String outputFile = "output" + i + ".mc";
                String inputC = "input" + i + ".c";
                String outputC = "output" + i + ".c";
                String code = new String(Files.readAllBytes(Paths.get(inputFile)));
                //parse tree
                CharStream input = CharStreams.fromString(code);
                MiniCLexer lexer = new MiniCLexer(input);
                CommonTokenStream tokens = new CommonTokenStream(lexer);
                MiniCParser parser = new MiniCParser(tokens);
                ParseTree tree = parser.program();
                //AST from parse tree
                ASTBuilderVisitor astBuilder = new ASTBuilderVisitor();
                ProgramNode ast = (ProgramNode) astBuilder.visit(tree);
                if (ast == null) {
                    System.out.println("AST is null for " + inputFile);
                    return;
                }
                //obfuscation
                ObfuscatorVisitor obfuscator = new ObfuscatorVisitor();
                String obfuscated = ast.accept(obfuscator);

                try (PrintWriter out = new PrintWriter(outputFile)) {
                    out.println(obfuscated);
                }
                System.out.println(ANSI_GREEN + "obfuscation complete for " + inputFile + ANSI_RESET);


                String code1 = Files.readString(Paths.get(inputFile));
                code1 = "#include <stdio.h>\n" + code1;
                Files.writeString(Paths.get(inputC), code1);

                String code2 = Files.readString(Paths.get(outputFile));
                code2 = "#include <stdio.h>\n" + code2;
                Files.writeString(Paths.get(outputC), code2);

                PerformanceComparator.compare(inputC, outputC);
            } catch (IOException e) {
                System.out.println("Error reading input" + i + ".mc" + e.getMessage());
            } catch (Exception e) {
                System.out.println("Error in input" + i + ".mc" + e.getMessage());
                e.printStackTrace();
            }
        }
    }
}
