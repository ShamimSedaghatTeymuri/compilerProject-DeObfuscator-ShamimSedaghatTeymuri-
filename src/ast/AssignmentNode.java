package ast;

public class AssignmentNode extends ExprNode{
    public final String variable;
    public final ExprNode value;

    public AssignmentNode(String variable, ExprNode value){
        this.variable = variable;
        this.value = value;
    }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
