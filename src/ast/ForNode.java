package ast;

public class ForNode implements StmtNode {
    public final ExprStmtNode init;
    public final ExprStmtNode condition;
    public final ExprNode update;
    public final StmtNode body;

    public ForNode(ExprStmtNode init, ExprStmtNode condition, ExprNode update, StmtNode body) {
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
