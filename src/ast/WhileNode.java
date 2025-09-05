package ast;

public class WhileNode implements StmtNode {
    public final ExprNode condition;
    public final StmtNode body;

    public WhileNode(ExprNode condition, StmtNode body) {
        this.condition = condition;
        this.body = body;
    }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
