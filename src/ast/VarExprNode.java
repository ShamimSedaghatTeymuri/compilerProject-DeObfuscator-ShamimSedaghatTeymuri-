package ast;

public class VarExprNode extends ExprNode {
    public final String name;

    public VarExprNode(String name) {
        this.name = name;
    }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
