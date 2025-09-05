package ast;

import org.antlr.v4.runtime.tree.ParseTree;
import parser.MiniCBaseVisitor;
import parser.MiniCParser;

import java.util.ArrayList;
import java.util.List;

public class ASTBuilderVisitor extends MiniCBaseVisitor<ASTNode> {

    @Override
    public ASTNode visitProgram(MiniCParser.ProgramContext ctx) {
        List<ASTNode> declarations = new ArrayList<>();
        for (ParseTree child : ctx.children) {
            ASTNode node = visit(child);
            if (node != null) {
                declarations.add(node);
            }
        }
        return new ProgramNode(declarations);
    }


    @Override
    public ASTNode visitFunctionDecl(MiniCParser.FunctionDeclContext ctx) {
        String type = ctx.type().getText();
        String name = ctx.ID().getText();
        List<ParamNode> params = new ArrayList<>();
        if (ctx.params() != null) {
            for (var p : ctx.params().param()) {
                params.add((ParamNode) visit(p));
            }
        }
        BlockNode body = (BlockNode) visit(ctx.block());
        return new FunctionDeclNode(type, name, params, body);
    }

    @Override
    public ASTNode visitParam(MiniCParser.ParamContext ctx) {
        return new ParamNode(ctx.type().getText(), ctx.ID().getText());
    }

    @Override
    public ASTNode visitBlock(MiniCParser.BlockContext ctx) {
        List<StmtNode> statements = new ArrayList<>();
        for (var stmt : ctx.statement()) {
            statements.add((StmtNode) visit(stmt));
        }
        return new BlockNode(statements);
    }

    @Override
    public ASTNode visitVarDecl(MiniCParser.VarDeclContext ctx) {
        String type = ctx.type().getText();
        String name = ctx.ID().getText();
        ExprNode init = ctx.expr() != null ? (ExprNode) visit(ctx.expr()) : null;
        return new VarDeclNode(type, name, init);
    }

    @Override
    public ASTNode visitExprSt(MiniCParser.ExprStContext ctx) {
        ExprNode expr = ctx.expr() != null ? (ExprNode) visit(ctx.expr()) : null;
        return new ExprStmtNode(expr);
    }

    @Override
    public ASTNode visitIfSt(MiniCParser.IfStContext ctx) {
        ExprNode cond = (ExprNode) visit(ctx.expr());
        StmtNode thenBranch = (StmtNode) visit(ctx.statement(0));
        StmtNode elseBranch = ctx.ELSE() != null ? (StmtNode) visit(ctx.statement(1)) : null;
        return new IfNode(cond, thenBranch, elseBranch);
    }

    @Override
    public ASTNode visitWhileSt(MiniCParser.WhileStContext ctx) {
        ExprNode cond = (ExprNode) visit(ctx.expr());
        StmtNode body = (StmtNode) visit(ctx.statement());
        return new WhileNode(cond, body);
    }

    @Override
    public ASTNode visitForSt(MiniCParser.ForStContext ctx) {
        ExprStmtNode init = (ExprStmtNode) visit(ctx.exprSt(0));
        ExprStmtNode cond = (ExprStmtNode) visit(ctx.exprSt(1));
        ExprNode update = ctx.expr() != null ? (ExprNode) visit(ctx.expr()) : null;
        StmtNode body = (StmtNode) visit(ctx.statement());
        return new ForNode(init, cond, update, body);
    }

    @Override
    public ASTNode visitReturnSt(MiniCParser.ReturnStContext ctx) {
        ExprNode expr = ctx.expr() != null ? (ExprNode) visit(ctx.expr()) : null;
        return new ReturnNode(expr);
    }

    @Override
    public ASTNode visitIoSt(MiniCParser.IoStContext ctx) {
        boolean isPrintf = ctx.PRINTF() != null;
        String format = ctx.STRING().getText();
        List<ExprNode> args = new ArrayList<>();
        List<String> ids = new ArrayList<>();

        if (isPrintf && ctx.expr() != null) {
            for (var e : ctx.expr()) {
                args.add((ExprNode) visit(e));
            }
        } else if (!isPrintf && ctx.ID() != null) {
            for (var id : ctx.ID()) {
                ids.add(id.getText());
            }
        }

        return new IOStmtNode(isPrintf, format, args, ids);
    }

    @Override
    public ASTNode visitExpr(MiniCParser.ExprContext ctx) {
        if (ctx.op != null && ctx.expr().size() == 2) {
            ExprNode left = (ExprNode) visit(ctx.expr(0));
            ExprNode right = (ExprNode) visit(ctx.expr(1));
            String op = ctx.op.getText();
            return new BinaryExprNode(left, op, right);
        }
        if (ctx.op != null && ctx.expr().size() == 1) {
            ExprNode operand = (ExprNode) visit(ctx.expr(0));
            return new UnaryExprNode(ctx.op.getText(), operand);
        }
        if (ctx.ID() != null && ctx.expr().size() == 1) {
            return new AssignmentNode(ctx.ID().getText(), (ExprNode) visit(ctx.expr(0)));
        }

        if (ctx.LPAREN() != null) {
            return visit(ctx.expr(0));
        }

        if (ctx.functionCall() != null) {
            return (ExprNode) visit(ctx.functionCall());
        }

        if (ctx.ID() != null) {
            return new VarExprNode(ctx.ID().getText());
        }


        if (ctx.NUMBER() != null || ctx.CHAR_LITERAL() != null || ctx.FALSE() != null || ctx.TRUE() != null) {
            return new LiteralExprNode(ctx.getText());
        }
        return null;
    }

    @Override
    public ASTNode visitFunctionCall(MiniCParser.FunctionCallContext ctx) {
        String name = ctx.ID().getText();
        List<ExprNode> args = new ArrayList<>();
        if (ctx.args() != null) {
            for (var arg : ctx.args().expr()) {
                args.add((ExprNode) visit(arg));
            }
        }
        return new FunctionCallNode(name, args);
    }

}


