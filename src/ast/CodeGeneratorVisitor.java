package ast;

public class CodeGeneratorVisitor implements ASTVisitor<String> {

    private String indent = "";
    private final String INDENT_STEP = "    ";

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
        StringBuilder sb = new StringBuilder();
        sb.append(node.returnType).append(" ").append(node.name).append("(");
        for (int i = 0; i < node.params.size(); i++) {
            sb.append(node.params.get(i).accept(this));
            if (i < node.params.size() - 1) sb.append(", ");
        }
        sb.append(")");
        sb.append(node.body.accept(this));
        return sb.toString();
    }

    @Override
    public String visit(ParamNode node) {
        return node.type + " " + node.name;
    }

    @Override
    public String visit(BlockNode node) {
        StringBuilder sb = new StringBuilder();
        sb.append("{\n");
        indent += INDENT_STEP;
        for (StmtNode stmt : node.statements) {
            sb.append(withIndent(stmt.accept(this))).append("\n");
        }
        indent = indent.substring(0, indent.length() - INDENT_STEP.length());
        sb.append("}");
        return sb.toString();
    }

    @Override
    public String visit(VarDeclNode node) {
        StringBuilder sb = new StringBuilder();
        sb.append(node.type).append(" ").append(node.name);
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
        StringBuilder sb = new StringBuilder();
        sb.append("if (").append(node.condition.accept(this)).append(") ").append(node.thenStmt.accept(this));
        if (node.elseStmt != null) {
            sb.append(" else ").append(node.elseStmt.accept(this));
        }
        return sb.toString();
    }

    @Override
    public String visit(WhileNode node) {
        return "while (" + node.condition.accept(this) + ") " + node.body.accept(this);
    }

    @Override
    public String visit(ForNode node) {
        String init = node.init.accept(this);
        String cond = node.condition.accept(this);
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
                sb.append(", ").append(id);
            }
            sb.append(");");
        }
        return sb.toString();
    }

    @Override
    public String visit(AssignmentNode node) {
        return node.variable + " = " + node.value.accept(this);
    }

    @Override
    public String visit(BinaryExprNode node) {
        return "(" + node.left.accept(this) + " " + node.op + " " + node.right.accept(this) + ")";
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
        return node.name;
    }

    @Override
    public String visit(FunctionCallNode node) {
        StringBuilder sb = new StringBuilder();
        sb.append(node.name).append("(");
        for (int i = 0; i < node.args.size(); i++) {
            sb.append(node.args.get(i).accept(this));
            if (i < node.args.size() - 1) sb.append(", ");
        }
        sb.append(")");
        return sb.toString();
    }
}
