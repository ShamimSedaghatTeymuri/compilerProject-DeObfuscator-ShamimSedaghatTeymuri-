package ast;

public class ReturnNode implements StmtNode {
    public final ExprNode expr;

    public ReturnNode(ExprNode expr) {
        this.expr = expr;
    }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
