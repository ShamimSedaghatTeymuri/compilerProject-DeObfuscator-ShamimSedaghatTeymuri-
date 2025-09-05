package ast;

public class UnaryExprNode extends ExprNode {
    public final String operator;
    public final ExprNode operand;

    public UnaryExprNode(String operator, ExprNode operand) {
        this.operator = operator;
        this.operand = operand;
    }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
