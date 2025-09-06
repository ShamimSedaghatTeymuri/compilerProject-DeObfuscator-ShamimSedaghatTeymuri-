package ast;

import java.util.List;

public class FunctionCallNode extends ExprNode {
    public String name;
    public List<ExprNode> args;

    public FunctionCallNode(String name, List<ExprNode> args) {
        this.name = name;
        this.args = args;
    }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
