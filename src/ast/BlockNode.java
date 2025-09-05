package ast;

import java.util.List;

public class BlockNode implements StmtNode {
    public final List<StmtNode> statements;

    public BlockNode(List<StmtNode> statements) {
        this.statements = statements;
    }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }

}
