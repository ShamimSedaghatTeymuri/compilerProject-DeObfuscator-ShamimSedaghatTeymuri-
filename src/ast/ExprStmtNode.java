package ast;

public class ExprStmtNode implements StmtNode {
    public final ExprNode expr;

    public ExprStmtNode(ExprNode expr) {
        this.expr = expr;
    }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
