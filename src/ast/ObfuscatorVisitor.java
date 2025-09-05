package ast;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class ObfuscatorVisitor implements ASTVisitor<String> {
    private final Map<String, String> nameMap = new HashMap<>();
    private int varCount = 0;
    private int funcCount = 0;
    private int xCount = 0;
    private int yCount = 0;
    private int zCount = 0;
    private final String INDENT_STEP = "    ";
    private String indent = "";

    private String getObfuscatedName(String original, boolean isFunction) {
        if (nameMap.containsKey(original)) {
            return nameMap.get(original);
        }
        if (isFunction && original.equals("main")) {
            return "main";
        }
        String obfuscatedName = isFunction ? "f" + funcCount++ : "v" + varCount++;
        nameMap.put(original, obfuscatedName);
        return obfuscatedName;
    }

    private String generateDeadCode() {
        Random r = new Random();
        int choice = r.nextInt(4);
        return switch (choice) {
            case 0 -> "int x" + xCount++ + " = " + r.nextInt(100) + ";";
            case 1 -> "if (0) {\n\t\tint z" + zCount++ + " = " + r.nextInt(100) + ";\n\t}";
            case 2 -> "if (1 > 2){\n\t\tint y" + yCount++ + " = " + r.nextInt(10) + ";\n\t}";
            case 3 -> "for (int i = 0; i < 0; i++) {\n\t\tint loop = i * 42;\n\t}";
            default -> "//dead code";
        };
    }

    private String withIndent(String code) {
        return indent + code;
    }

    @Override
    public String visit(ProgramNode node) {
        StringBuilder sb = new StringBuilder();
        for (ASTNode decl : node.declarations) {
            sb.append(decl.accept(this)).append("\n");
        }
        return sb.toString();
    }

    @Override
    public String visit(FunctionDeclNode node) {
        String returnType = node.returnType;
        String obfuscatedName = getObfuscatedName(node.name, true);

        StringBuilder sb = new StringBuilder();
        sb.append(returnType).append(" ").append(obfuscatedName).append("(");
        for (int i = 0; i < node.params.size(); i++) {
            sb.append(node.params.get(i).accept(this));
            if (i < node.params.size() - 1) {
                sb.append(", ");
            }
        }
        sb.append(") ").append(node.body.accept(this));
        return sb.toString();
    }

    @Override
    public String visit(ParamNode node) {
        String obfuscatedName = getObfuscatedName(node.name, false);
        return node.type + " " + obfuscatedName;
    }

    @Override
    public String visit(BlockNode node) {
        StringBuilder sb = new StringBuilder();
        sb.append("{\n");
        indent += INDENT_STEP;
        sb.append(withIndent(generateDeadCode())).append("\n");
        for (StmtNode stmt : node.statements) {
            sb.append(withIndent(stmt.accept(this))).append("\n");
            if (Math.random() < 0.8) {
                sb.append(withIndent(generateDeadCode())).append("\n");
            }
        }
        indent = indent.substring(0, indent.length() - INDENT_STEP.length());
        sb.append("}");
        return sb.toString();
    }

    @Override
    public String visit(VarDeclNode node) {
        String obfuscatedName = getObfuscatedName(node.name, false);
        StringBuilder sb = new StringBuilder();
        sb.append(node.type).append(" ").append(obfuscatedName);
        if (node.initializer != null) {
            sb.append(" = ").append(node.initializer.accept(this));
        }
        sb.append(";");
        return sb.toString();
    }

    @Override
    public String visit(ReturnNode node) {
        return node.expr != null ? "return " + node.expr.accept(this) + ";" : "return;";
    }

    @Override
    public String visit(ExprStmtNode node) {
        return (node.expr != null ? node.expr.accept(this) : "") + ";";
    }

    @Override
    public String visit(IfNode node) {
        String condition = node.condition.accept(this);

        if (node.condition instanceof VarExprNode || node.condition instanceof FunctionCallNode) {
            condition = "!!" + condition;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("if (").append(condition).append(") ").append(node.thenStmt.accept(this));
        if (node.elseStmt != null) {
            sb.append(" else ").append(node.elseStmt.accept(this));
        }
        return sb.toString();
    }

    @Override
    public String visit(WhileNode node) {
        return "while (" + node.condition.accept(this) + ")" + node.body.accept(this);
    }

    @Override
    public String visit(ForNode node) {
        String init = node.init.expr != null ? node.init.expr.accept(this) : "";
        String cond = node.condition.expr != null ? node.condition.expr.accept(this) : "";
        String update = node.update != null ? node.update.accept(this) : "";
        return "for (" + init + "; " + cond + "; " + update + ") " + node.body.accept(this);
    }

    @Override
    public String visit(IOStmtNode node) {
        StringBuilder sb = new StringBuilder();
        if (node.isPrintf) {
            sb.append("printf(").append(node.format);
            for (ExprNode expr : node.expressions) {
                sb.append(", ").append(expr.accept(this));
            }
            sb.append(");");
        } else {
            sb.append("scanf(").append(node.format);
            for (String id : node.ids) {
                sb.append(", ").append(getObfuscatedName(id, false));
            }
            sb.append(");");
        }
        return sb.toString();
    }

    @Override
    public String visit(AssignmentNode node) {
        String variable = getObfuscatedName(node.variable, false);
        String value = node.value.accept(this);

        if (node.value instanceof VarExprNode || node.value instanceof LiteralExprNode) {
            return variable + " = (0 + " + value + ")";
        }

        return variable + " = " + value;
    }

    @Override
    public String visit(BinaryExprNode node) {
        String left = node.left.accept(this);
        String right = node.right.accept(this);
        String op = node.op;

        if (op.equals("+") && node.right instanceof LiteralExprNode) {
            try {
                int value = Integer.parseInt(((LiteralExprNode) node.right).value);
                return "(" + left + " - (" + (-value) + "))";
            } catch (NumberFormatException ignored) {
            }
        }

        if (op.equals("*") && node.right instanceof LiteralExprNode) {
            try {
                int value = Integer.parseInt(((LiteralExprNode) node.right).value);
                if ((value & (value - 1)) == 0) {
                    int shiftCount = Integer.numberOfTrailingZeros(value);
                    return "(" + left + " << " + shiftCount + ")";
                }
            } catch (NumberFormatException ignored) {
            }
        }

        if (op.equals("/") && node.right instanceof LiteralExprNode) {
            try {
                int value = Integer.parseInt(((LiteralExprNode) node.right).value);
                if ((value & (value - 1)) == 0) {
                    int shiftCount = Integer.numberOfTrailingZeros(value);
                    return "(" + left + " >> " + shiftCount + ")";
                }
            } catch (NumberFormatException ignored) {
            }
        }
        return "(" + left + " " + node.op + " " + right + ")";
    }

    @Override
    public String visit(UnaryExprNode node) {
        return node.operator + node.operand.accept(this);
    }

    @Override
    public String visit(LiteralExprNode node) {
        return node.value;
    }

    @Override
    public String visit(VarExprNode node) {
        return getObfuscatedName(node.name, false);
    }

    @Override
    public String visit(FunctionCallNode node) {
        StringBuilder sb = new StringBuilder();
        sb.append(getObfuscatedName(node.name, true)).append("(");
        for (int i = 0; i < node.args.size(); i++) {
            sb.append(node.args.get(i).accept(this));
            if (i < node.args.size() - 1) {
                sb.append(", ");
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
