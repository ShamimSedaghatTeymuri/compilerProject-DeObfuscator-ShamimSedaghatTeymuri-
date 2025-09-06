package ast;

import java.util.ArrayList;
import java.util.List;

public class DeObfuscatorVisitor implements ASTVisitor<ASTNode> {

    @Override
    public ASTNode visit(ProgramNode node) {
        List<ASTNode> newDeclarations = new ArrayList<>();
        for (ASTNode decl : node.declarations) {
            ASTNode newDecl = decl.accept(this);
            if (newDecl != null) {
                newDeclarations.add(newDecl);
            }
        }
        return new ProgramNode(newDeclarations);
    }

    @Override
    public ASTNode visit(FunctionDeclNode node) {
        List<ParamNode> newParams = new ArrayList<>();
        for (ParamNode param : node.params) {
            newParams.add((ParamNode) param.accept(this));
        }
        BlockNode newBody = (BlockNode) node.body.accept(this);
        return new FunctionDeclNode(node.returnType, node.name, newParams, newBody);
    }

    @Override
    public ASTNode visit(ParamNode node) {
        return node;
    }

    @Override
    public ASTNode visit(BlockNode node) {
        List<StmtNode> newStatements = new ArrayList<>();
        for (StmtNode stmt : node.statements) {
            ASTNode newStmt = stmt.accept(this);
            if (newStmt != null) {
                newStatements.add((StmtNode) newStmt);
            }
        }
        return new BlockNode(newStatements);
    }

    @Override
    public ASTNode visit(VarDeclNode node) {
        ExprNode newInit = node.initializer != null ? (ExprNode) node.initializer.accept(this) : null;
        return new VarDeclNode(node.type, node.name, newInit);
    }

    @Override
    public ASTNode visit(ReturnNode node) {
        ExprNode newExpr = node.expr != null ? (ExprNode) node.expr.accept(this) : null;
        return new ReturnNode(newExpr);
    }

    @Override
    public ASTNode visit(ExprStmtNode node) {
        ExprNode newExpr = node.expr != null ? (ExprNode) node.expr.accept(this) : null;
        return new ExprStmtNode(newExpr);
    }

    @Override
    public ASTNode visit(IfNode node) {
        ExprNode newCond = (ExprNode) node.condition.accept(this);
        StmtNode newThen = (StmtNode) node.thenStmt.accept(this);
        StmtNode newElse = node.elseStmt != null ? (StmtNode) node.elseStmt.accept(this) : null;

        if (isConstantFalse(newCond)) {
            return newElse;
        } else if (isConstantTrue(newCond)) {
            return newThen;
        } else {
            return new IfNode(newCond, newThen, newElse);
        }
    }

    @Override
    public ASTNode visit(WhileNode node) {
        ExprNode newCond = (ExprNode) node.condition.accept(this);
        StmtNode newBody = (StmtNode) node.body.accept(this);

        if (isConstantFalse(newCond)) {
            return null;
        } else {
            return new WhileNode(newCond, newBody);
        }
    }

    @Override
    public ASTNode visit(ForNode node) {
        ASTNode newInit = node.init != null ? node.init.accept(this) : null;
        ExprNode newCond = node.condition != null ? (ExprNode) node.condition.accept(this) : null;
        ExprNode newUpdate = node.update != null ? (ExprNode) node.update.accept(this) : null;
        StmtNode newBody = (StmtNode) node.body.accept(this);

        if (newCond != null && isConstantFalse(newCond)) {
            return null;
        }

        if (newInit instanceof VarDeclNode) {
            List<StmtNode> statements = new ArrayList<>();
            statements.add((StmtNode) newInit);
            statements.add(new ForNode(null, newCond, newUpdate, newBody));
            return new BlockNode(statements);
        }

        return new ForNode(newInit, newCond, newUpdate, newBody);
    }

    @Override
    public ASTNode visit(IOStmtNode node) {
        List<ExprNode> newExprs = new ArrayList<>();
        for (ExprNode expr : node.expressions) {
            newExprs.add((ExprNode) expr.accept(this));
        }
        return new IOStmtNode(node.isPrintf, node.format, newExprs, node.ids);
    }

    @Override
    public ASTNode visit(AssignmentNode node) {
        ExprNode newValue = (ExprNode) node.value.accept(this);
        newValue = simplifyExpression(newValue);
        return new AssignmentNode(node.variable, newValue);
    }

    @Override
    public ASTNode visit(BinaryExprNode node) {
        ExprNode left = (ExprNode) node.left.accept(this);
        ExprNode right = (ExprNode) node.right.accept(this);
        String op = node.op;

        Integer constantValue = evaluateConstantExpr(new BinaryExprNode(left, op, right));
        if (constantValue != null) {
            return new LiteralExprNode(constantValue.toString());
        }

        if (op.equals("+")) {
            if (isZero(left)) {
                return right;
            } else if (isZero(right)) {
                return left;
            }
        } else if (op.equals("-")) {
            if (isZero(right)) {
                return left;
            } else if (isZero(left)) {
                return new UnaryExprNode("-", right);
            }
        } else if (op.equals("*")) {
            if (isOne(left)) {
                return right;
            } else if (isOne(right)) {
                return left;
            } else if (isZero(left) || isZero(right)) {
                return new LiteralExprNode("0");
            }
        } else if (op.equals("/")) {
            if (isOne(right)) {
                return left;
            } else if (isZero(left)) {
                return new LiteralExprNode("0");
            }
        } else if (op.equals("<<")) {
            if (right instanceof LiteralExprNode) {
                try {
                    int shift = Integer.parseInt(((LiteralExprNode) right).value);
                    if (shift >= 0) {
                        int multiplier = 1 << shift;
                        return new BinaryExprNode(left, "*", new LiteralExprNode(String.valueOf(multiplier)));
                    }
                } catch (NumberFormatException e) {
                }
            }
        } else if (op.equals(">>")) {
            if (right instanceof LiteralExprNode) {
                try {
                    int shift = Integer.parseInt(((LiteralExprNode) right).value);
                    if (shift >= 0) {
                        int divisor = 1 << shift;
                        return new BinaryExprNode(left, "/", new LiteralExprNode(String.valueOf(divisor)));
                    }
                } catch (NumberFormatException e) {
                }
            }
        }

        return new BinaryExprNode(left, op, right);
    }

    @Override
    public ASTNode visit(UnaryExprNode node) {
        ExprNode operand = (ExprNode) node.operand.accept(this);
        String op = node.operator;

        Integer constantValue = evaluateConstantExpr(new UnaryExprNode(op, operand));
        if (constantValue != null) {
            return new LiteralExprNode(constantValue.toString());
        }

        if (op.equals("-") && operand instanceof UnaryExprNode && ((UnaryExprNode) operand).operator.equals("-")) {
            return ((UnaryExprNode) operand).operand;
        }

        return new UnaryExprNode(op, operand);
    }

    @Override
    public ASTNode visit(LiteralExprNode node) {
        return node;
    }

    @Override
    public ASTNode visit(VarExprNode node) {
        return node;
    }

    @Override
    public ASTNode visit(FunctionCallNode node) {
        List<ExprNode> newArgs = new ArrayList<>();
        for (ExprNode arg : node.args) {
            newArgs.add((ExprNode) arg.accept(this));
        }
        return new FunctionCallNode(node.name, newArgs);
    }

    private boolean isZero(ExprNode expr) {
        if (expr instanceof LiteralExprNode) {
            String value = ((LiteralExprNode) expr).value;
            return value.equals("0");
        }
        return false;
    }

    private boolean isOne(ExprNode expr) {
        if (expr instanceof LiteralExprNode) {
            String value = ((LiteralExprNode) expr).value;
            return value.equals("1");
        }
        return false;
    }

    private Integer evaluateConstantExpr(ExprNode expr) {
        if (expr instanceof LiteralExprNode) {
            try {
                return Integer.parseInt(((LiteralExprNode) expr).value);
            } catch (NumberFormatException e) {
                return null;
            }
        } else if (expr instanceof BinaryExprNode) {
            BinaryExprNode binExpr = (BinaryExprNode) expr;
            Integer left = evaluateConstantExpr(binExpr.left);
            Integer right = evaluateConstantExpr(binExpr.right);
            if (left == null || right == null) {
                return null;
            }
            switch (binExpr.op) {
                case "+": return left + right;
                case "-": return left - right;
                case "*": return left * right;
                case "/": return right != 0 ? left / right : null;
                case "%": return right != 0 ? left % right : null;
                case "<": return left < right ? 1 : 0;
                case ">": return left > right ? 1 : 0;
                case "<=": return left <= right ? 1 : 0;
                case ">=": return left >= right ? 1 : 0;
                case "==": return left == right ? 1 : 0;
                case "!=": return left != right ? 1 : 0;
                case "&&": return (left != 0 && right != 0) ? 1 : 0;
                case "||": return (left != 0 || right != 0) ? 1 : 0;
                default: return null;
            }
        } else if (expr instanceof UnaryExprNode) {
            UnaryExprNode unExpr = (UnaryExprNode) expr;
            Integer operand = evaluateConstantExpr(unExpr.operand);
            if (operand == null) {
                return null;
            }
            switch (unExpr.operator) {
                case "!": return operand == 0 ? 1 : 0;
                case "-": return -operand;
                default: return null;
            }
        }
        return null;
    }

    private boolean isConstantFalse(ExprNode expr) {
        Integer value = evaluateConstantExpr(expr);
        return value != null && value == 0;
    }

    private boolean isConstantTrue(ExprNode expr) {
        Integer value = evaluateConstantExpr(expr);
        return value != null && value != 0;
    }

    private ExprNode simplifyExpression(ExprNode expr) {
        if (expr instanceof BinaryExprNode) {
            BinaryExprNode binExpr = (BinaryExprNode) expr;
            if (binExpr.op.equals("+")) {
                if (isZero(binExpr.left)) {
                    return binExpr.right;
                } else if (isZero(binExpr.right)) {
                    return binExpr.left;
                }
            } else if (binExpr.op.equals("-")) {
                if (isZero(binExpr.right)) {
                    return binExpr.left;
                }
            }
        }
        return expr;
    }
}