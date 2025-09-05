package parser;
// Generated from MiniC.g4 by ANTLR 4.9.2
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link MiniCParser}.
 */
public interface MiniCListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link MiniCParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(MiniCParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniCParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(MiniCParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniCParser#functionDecl}.
	 * @param ctx the parse tree
	 */
	void enterFunctionDecl(MiniCParser.FunctionDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniCParser#functionDecl}.
	 * @param ctx the parse tree
	 */
	void exitFunctionDecl(MiniCParser.FunctionDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniCParser#params}.
	 * @param ctx the parse tree
	 */
	void enterParams(MiniCParser.ParamsContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniCParser#params}.
	 * @param ctx the parse tree
	 */
	void exitParams(MiniCParser.ParamsContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniCParser#param}.
	 * @param ctx the parse tree
	 */
	void enterParam(MiniCParser.ParamContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniCParser#param}.
	 * @param ctx the parse tree
	 */
	void exitParam(MiniCParser.ParamContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniCParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(MiniCParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniCParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(MiniCParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniCParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(MiniCParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniCParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(MiniCParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniCParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(MiniCParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniCParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(MiniCParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniCParser#exprSt}.
	 * @param ctx the parse tree
	 */
	void enterExprSt(MiniCParser.ExprStContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniCParser#exprSt}.
	 * @param ctx the parse tree
	 */
	void exitExprSt(MiniCParser.ExprStContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniCParser#ifSt}.
	 * @param ctx the parse tree
	 */
	void enterIfSt(MiniCParser.IfStContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniCParser#ifSt}.
	 * @param ctx the parse tree
	 */
	void exitIfSt(MiniCParser.IfStContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniCParser#whileSt}.
	 * @param ctx the parse tree
	 */
	void enterWhileSt(MiniCParser.WhileStContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniCParser#whileSt}.
	 * @param ctx the parse tree
	 */
	void exitWhileSt(MiniCParser.WhileStContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniCParser#forSt}.
	 * @param ctx the parse tree
	 */
	void enterForSt(MiniCParser.ForStContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniCParser#forSt}.
	 * @param ctx the parse tree
	 */
	void exitForSt(MiniCParser.ForStContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniCParser#returnSt}.
	 * @param ctx the parse tree
	 */
	void enterReturnSt(MiniCParser.ReturnStContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniCParser#returnSt}.
	 * @param ctx the parse tree
	 */
	void exitReturnSt(MiniCParser.ReturnStContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniCParser#ioSt}.
	 * @param ctx the parse tree
	 */
	void enterIoSt(MiniCParser.IoStContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniCParser#ioSt}.
	 * @param ctx the parse tree
	 */
	void exitIoSt(MiniCParser.IoStContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniCParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(MiniCParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniCParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(MiniCParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniCParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void enterFunctionCall(MiniCParser.FunctionCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniCParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void exitFunctionCall(MiniCParser.FunctionCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniCParser#args}.
	 * @param ctx the parse tree
	 */
	void enterArgs(MiniCParser.ArgsContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniCParser#args}.
	 * @param ctx the parse tree
	 */
	void exitArgs(MiniCParser.ArgsContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniCParser#varDecl}.
	 * @param ctx the parse tree
	 */
	void enterVarDecl(MiniCParser.VarDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniCParser#varDecl}.
	 * @param ctx the parse tree
	 */
	void exitVarDecl(MiniCParser.VarDeclContext ctx);
}