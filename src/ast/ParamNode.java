package ast;

public class ParamNode implements ASTNode {
    public final String name;
    public final String type;

    public ParamNode(String type, String name) {
        this.name = name;
        this.type = type;
    }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
