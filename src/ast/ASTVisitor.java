package ast;

public interface ASTVisitor<T> {
    T visit(ProgramNode nose);

    T visit(FunctionDeclNode node);

    T visit(BlockNode node);

    T visit(ParamNode node);

    T visit(VarDeclNode node);

    T visit(ReturnNode node);

    T visit(ExprStmtNode node);
    T visit(IfNode node);
    T visit(WhileNode node);
    T visit(ForNode node);
    T visit(IOStmtNode node);
    T visit(AssignmentNode node);

    T visit(BinaryExprNode node);
    T visit(UnaryExprNode node);
    T visit(VarExprNode node);
    T visit(LiteralExprNode node);
    T visit(FunctionCallNode node);
}
