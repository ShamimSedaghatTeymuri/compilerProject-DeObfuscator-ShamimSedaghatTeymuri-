package ast;

public class ForNode implements StmtNode {
    public final ASTNode init;
    public final ExprNode condition;
    public final ExprNode update;
    public final StmtNode body;

    public ForNode(ASTNode init, ExprNode condition, ExprNode update, StmtNode body) {
        this.init = init;
        this.condition = condition;
        this.update = update;
        this.body = body;
    }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
