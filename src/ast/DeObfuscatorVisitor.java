package ast;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.ArrayList;
import java.util.List;

public class DeObfuscatorVisitor implements ASTVisitor<ASTNode> {
    private final Map<String, String> nameMap = new HashMap<>();
    private final Map<String, Integer> nameCounter = new HashMap<>();
    private final Pattern vPattern = Pattern.compile("^v(\\d+)$");
    private final Pattern fPattern = Pattern.compile("^f(\\d+)$");

    private final Map<String, String> variableTypes = new HashMap<>();

    private String deobfuscateName(String original, boolean isFunction, ExprNode initializer) {
        if ("main".equals(original)) return "main";
        if (nameMap.containsKey(original)) return nameMap.get(original);

        String newName;
        Matcher mv = vPattern.matcher(original);
        Matcher mf = fPattern.matcher(original);

        if (mv.matches()) {
            newName = pickNameByExpr(initializer);
        } else if (mf.matches()) {
            newName = "func" + mf.group(1);
        } else {
            newName = original.replaceAll("[^A-Za-z0-9_]", "_");
            if (!newName.isEmpty() && Character.isDigit(newName.charAt(0)))
                newName = "v_" + newName;
        }

        int idx = nameCounter.getOrDefault(newName, 0) + 1;
        nameCounter.put(newName, idx);
        if (idx > 1) newName += idx;

        nameMap.put(original, newName);
        return newName;
    }

    private String pickNameByExpr(ExprNode expr) {
        if (expr instanceof BinaryExprNode) {
            BinaryExprNode bin = (BinaryExprNode) expr;
            switch (bin.op) {
                case "+": return "sum";
                case "-": return "diff";
                case "*": return "product";
                case "/": return "quotient";
                case "%": return "remainder";
                case "<": return "isLess";
                case ">": return "isGreater";
                case "<=": return "isLessOrEqual";
                case ">=": return "isGreaterOrEqual";
                case "==": return "isEqual";
                case "!=": return "isNotEqual";
                case "&&": return "andResult";
                case "||": return "orResult";
            }
        } else if (expr instanceof UnaryExprNode) {
            UnaryExprNode un = (UnaryExprNode) expr;
            switch (un.operator) {
                case "!": return "not";
                case "-": return "negative";
            }
        } else if (expr instanceof FunctionCallNode) {
            FunctionCallNode funcCall = (FunctionCallNode) expr;
            return funcCall.name + "Result";
        } else if (expr instanceof VarExprNode) {
            VarExprNode var = (VarExprNode) expr;

            String type = variableTypes.get(var.name);
            if (type != null) {
                switch (type) {
                    case "int": return "intValue";
                    case "char": return "charValue";
                    case "bool": return "boolValue";
                }
            }
            return "value";
        } else if (expr instanceof LiteralExprNode) {
            LiteralExprNode lit = (LiteralExprNode) expr;
            if (lit.value.equals("true") || lit.value.equals("false")) {
                return "flag";
            } else if (Character.isDigit(lit.value.charAt(0))) {
                return "number";
            } else if (lit.value.startsWith("'")) {
                return "character";
            }
        }

        if (expr instanceof BinaryExprNode) {
            BinaryExprNode bin = (BinaryExprNode) expr;
            String leftName = getBaseName(bin.left);
            String rightName = getBaseName(bin.right);

            if (!leftName.equals("value") && !rightName.equals("value")) {
                return leftName + "_" + bin.op + "_" + rightName;
            }
        }

        return "value";
    }

    private String getBaseName(ExprNode expr) {
        if (expr instanceof VarExprNode) {
            VarExprNode var = (VarExprNode) expr;
            if (nameMap.containsKey(var.name)) {
                return nameMap.get(var.name);
            }
            return var.name.replace("v", "var");
        } else if (expr instanceof LiteralExprNode) {
            LiteralExprNode lit = (LiteralExprNode) expr;
            return lit.value;
        }
        return "value";
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
            } else if (binExpr.op.equals("*")) {
                if (isOne(binExpr.left)) {
                    return binExpr.right;
                } else if (isOne(binExpr.right)) {
                    return binExpr.left;
                } else if (isZero(binExpr.left) || isZero(binExpr.right)) {
                    return new LiteralExprNode("0");
                }
            } else if (binExpr.op.equals("/")) {
                if (isOne(binExpr.right)) {
                    return binExpr.left;
                } else if (isZero(binExpr.left)) {
                    return new LiteralExprNode("0");
                }
            }
        }
        return expr;
    }

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
        node.name = deobfuscateName(node.name, true, null);

        List<ParamNode> newParams = new ArrayList<>();
        for (ParamNode param : node.params) {
            newParams.add((ParamNode) param.accept(this));
        }
        BlockNode newBody = (BlockNode) node.body.accept(this);
        return new FunctionDeclNode(node.returnType, node.name, newParams, newBody);
    }

    @Override
    public ASTNode visit(ParamNode node) {
        node.name = deobfuscateName(node.name, false, null);
        variableTypes.put(node.name, node.type);
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

        node.name = deobfuscateName(node.name, false, newInit);

        variableTypes.put(node.name, node.type);

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

        return new ForNode(newInit, newCond, newUpdate, newBody);
    }

    @Override
    public ASTNode visit(IOStmtNode node) {
        List<ExprNode> newExprs = new ArrayList<>();
        for (ExprNode expr : node.expressions) {
            newExprs.add((ExprNode) expr.accept(this));
        }

        List<String> newIds = new ArrayList<>();
        for (String id : node.ids) {
            if (nameMap.containsKey(id)) {
                newIds.add(nameMap.get(id));
            } else {
                newIds.add(deobfuscateName(id, false, null));
            }
        }

        return new IOStmtNode(node.isPrintf, node.format, newExprs, newIds);
    }

    @Override
    public ASTNode visit(AssignmentNode node) {
        ExprNode newValue = (ExprNode) node.value.accept(this);

        node.variable = deobfuscateName(node.variable, false, newValue);

        newValue = simplifyExpression(newValue);
        return new AssignmentNode(node.variable, newValue);
    }

    @Override
    public ASTNode visit(BinaryExprNode node) {
        if (node.right == null) {
            return node.left != null ? node.left.accept(this) : node;
        }

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
                    // ignore
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
                    // ignore
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
        if (nameMap.containsKey(node.name)) {
            node.name = nameMap.get(node.name);
        } else {
            node.name = deobfuscateName(node.name, false, null);
        }
        return node;
    }

    @Override
    public ASTNode visit(FunctionCallNode node) {
        if (nameMap.containsKey(node.name)) {
            node.name = nameMap.get(node.name);
        } else {
            node.name = deobfuscateName(node.name, true, null);
        }

        List<ExprNode> newArgs = new ArrayList<>();
        for (ExprNode arg : node.args) {
            newArgs.add((ExprNode) arg.accept(this));
        }
        return new FunctionCallNode(node.name, newArgs);
    }
}