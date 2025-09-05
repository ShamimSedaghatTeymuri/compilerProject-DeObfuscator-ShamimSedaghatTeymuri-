package ast;

public class LiteralExprNode extends ExprNode {
    public final String value;

    public LiteralExprNode(String value) {
        this.value = value;
    }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
