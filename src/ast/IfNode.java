package ast;

public class IfNode implements StmtNode{
    public final ExprNode condition;
    public final StmtNode thenStmt;
    public final StmtNode elseStmt;

    public IfNode(ExprNode condition, StmtNode thenStmt, StmtNode elseStmt){
        this.condition = condition;
        this.thenStmt = thenStmt;
        this.elseStmt = elseStmt;
    }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
