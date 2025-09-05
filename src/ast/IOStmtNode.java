package ast;

import java.util.List;

public class IOStmtNode implements StmtNode {
    public final boolean isPrintf;
    public final String format;
    public final List<ExprNode> expressions;
    public final List<String> ids;

    public IOStmtNode(boolean isPrintf, String format, List<ExprNode> expressions, List<String> ids){
        this.isPrintf = isPrintf;
        this.format = format;
        this.expressions = expressions;
        this.ids = ids;
    }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
