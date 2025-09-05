package parser;
// Generated from MiniC.g4 by ANTLR 4.9.2

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link MiniCParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 *            operations with no return type.
 */
public interface MiniCVisitor<T> extends ParseTreeVisitor<T> {
    /**
     * Visit a parse tree produced by {@link MiniCParser#program}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitProgram(MiniCParser.ProgramContext ctx);

    /**
     * Visit a parse tree produced by {@link MiniCParser#functionDecl}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitFunctionDecl(MiniCParser.FunctionDeclContext ctx);

    /**
     * Visit a parse tree produced by {@link MiniCParser#params}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitParams(MiniCParser.ParamsContext ctx);

    /**
     * Visit a parse tree produced by {@link MiniCParser#param}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitParam(MiniCParser.ParamContext ctx);

    /**
     * Visit a parse tree produced by {@link MiniCParser#type}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitType(MiniCParser.TypeContext ctx);

    /**
     * Visit a parse tree produced by {@link MiniCParser#block}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitBlock(MiniCParser.BlockContext ctx);

    /**
     * Visit a parse tree produced by {@link MiniCParser#statement}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitStatement(MiniCParser.StatementContext ctx);

    /**
     * Visit a parse tree produced by {@link MiniCParser#exprSt}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitExprSt(MiniCParser.ExprStContext ctx);

    /**
     * Visit a parse tree produced by {@link MiniCParser#ifSt}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitIfSt(MiniCParser.IfStContext ctx);

    /**
     * Visit a parse tree produced by {@link MiniCParser#whileSt}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitWhileSt(MiniCParser.WhileStContext ctx);

    /**
     * Visit a parse tree produced by {@link MiniCParser#forSt}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitForSt(MiniCParser.ForStContext ctx);

    /**
     * Visit a parse tree produced by {@link MiniCParser#returnSt}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitReturnSt(MiniCParser.ReturnStContext ctx);

    /**
     * Visit a parse tree produced by {@link MiniCParser#ioSt}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitIoSt(MiniCParser.IoStContext ctx);

    /**
     * Visit a parse tree produced by {@link MiniCParser#expr}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitExpr(MiniCParser.ExprContext ctx);

    /**
     * Visit a parse tree produced by {@link MiniCParser#functionCall}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitFunctionCall(MiniCParser.FunctionCallContext ctx);

    /**
     * Visit a parse tree produced by {@link MiniCParser#args}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitArgs(MiniCParser.ArgsContext ctx);

    /**
     * Visit a parse tree produced by {@link MiniCParser#varDecl}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitVarDecl(MiniCParser.VarDeclContext ctx);
}