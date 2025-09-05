package ast;

import java.util.List;

public class ProgramNode implements ASTNode {
    public final List<ASTNode> declarations;

    public ProgramNode(List<ASTNode> declarations) {
        this.declarations = declarations;
    }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }

}
