package ast;

public class VarDeclNode implements StmtNode {
    public final String name;
    public final String type;
    public final ExprNode initializer;

    public VarDeclNode(String type, String name, ExprNode initializer) {
        this.name = name;
        this.type = type;
        this.initializer = initializer;
    }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
