package ast;

public class VarDeclNode implements StmtNode {
    public String name;
    public String type;
    public ExprNode initializer;

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
