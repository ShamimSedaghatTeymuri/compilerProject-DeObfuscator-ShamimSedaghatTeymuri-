// Generated from MiniC.g4 by ANTLR 4.9.2
package parser;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class MiniCParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, INT=3, CHAR=4, BOOL=5, IF=6, ELSE=7, WHILE=8, FOR=9, RETURN=10, 
		PRINTF=11, SCANF=12, TRUE=13, FALSE=14, PLUS=15, MINUS=16, MULT=17, DIV=18, 
		MOD=19, ASSIGN=20, EQ=21, NEQ=22, LT=23, GT=24, LE=25, GE=26, AND=27, 
		OR=28, NOT=29, SEMI=30, COMMA=31, LPAREN=32, RPAREN=33, LBRACE=34, RBRACE=35, 
		ID=36, NUMBER=37, CHAR_LITERAL=38, STRING=39, WS=40;
	public static final int
		RULE_program = 0, RULE_functionDecl = 1, RULE_params = 2, RULE_param = 3, 
		RULE_type = 4, RULE_block = 5, RULE_statement = 6, RULE_exprSt = 7, RULE_ifSt = 8, 
		RULE_whileSt = 9, RULE_forSt = 10, RULE_returnSt = 11, RULE_ioSt = 12, 
		RULE_expr = 13, RULE_functionCall = 14, RULE_args = 15, RULE_varDecl = 16;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "functionDecl", "params", "param", "type", "block", "statement", 
			"exprSt", "ifSt", "whileSt", "forSt", "returnSt", "ioSt", "expr", "functionCall", 
			"args", "varDecl"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'<<'", "'>>'", "'int'", "'char'", "'bool'", "'if'", "'else'", 
			"'while'", "'for'", "'return'", "'printf'", "'scanf'", "'true'", "'false'", 
			"'+'", "'-'", "'*'", "'/'", "'%'", "'='", "'=='", "'!='", "'<'", "'>'", 
			"'<='", "'>='", "'&&'", "'||'", "'!'", "';'", "','", "'('", "')'", "'{'", 
			"'}'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, "INT", "CHAR", "BOOL", "IF", "ELSE", "WHILE", "FOR", 
			"RETURN", "PRINTF", "SCANF", "TRUE", "FALSE", "PLUS", "MINUS", "MULT", 
			"DIV", "MOD", "ASSIGN", "EQ", "NEQ", "LT", "GT", "LE", "GE", "AND", "OR", 
			"NOT", "SEMI", "COMMA", "LPAREN", "RPAREN", "LBRACE", "RBRACE", "ID", 
			"NUMBER", "CHAR_LITERAL", "STRING", "WS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "MiniC.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public MiniCParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ProgramContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(MiniCParser.EOF, 0); }
		public List<FunctionDeclContext> functionDecl() {
			return getRuleContexts(FunctionDeclContext.class);
		}
		public FunctionDeclContext functionDecl(int i) {
			return getRuleContext(FunctionDeclContext.class,i);
		}
		public List<VarDeclContext> varDecl() {
			return getRuleContexts(VarDeclContext.class);
		}
		public VarDeclContext varDecl(int i) {
			return getRuleContext(VarDeclContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).exitProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniCVisitor ) return ((MiniCVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(38);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << CHAR) | (1L << BOOL))) != 0)) {
				{
				setState(36);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
				case 1:
					{
					setState(34);
					functionDecl();
					}
					break;
				case 2:
					{
					setState(35);
					varDecl();
					}
					break;
				}
				}
				setState(40);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(41);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunctionDeclContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(MiniCParser.ID, 0); }
		public TerminalNode LPAREN() { return getToken(MiniCParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(MiniCParser.RPAREN, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public ParamsContext params() {
			return getRuleContext(ParamsContext.class,0);
		}
		public FunctionDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).enterFunctionDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).exitFunctionDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniCVisitor ) return ((MiniCVisitor<? extends T>)visitor).visitFunctionDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionDeclContext functionDecl() throws RecognitionException {
		FunctionDeclContext _localctx = new FunctionDeclContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_functionDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(43);
			type();
			setState(44);
			match(ID);
			setState(45);
			match(LPAREN);
			setState(47);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << CHAR) | (1L << BOOL))) != 0)) {
				{
				setState(46);
				params();
				}
			}

			setState(49);
			match(RPAREN);
			setState(50);
			block();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParamsContext extends ParserRuleContext {
		public List<ParamContext> param() {
			return getRuleContexts(ParamContext.class);
		}
		public ParamContext param(int i) {
			return getRuleContext(ParamContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(MiniCParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(MiniCParser.COMMA, i);
		}
		public ParamsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_params; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).enterParams(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).exitParams(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniCVisitor ) return ((MiniCVisitor<? extends T>)visitor).visitParams(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParamsContext params() throws RecognitionException {
		ParamsContext _localctx = new ParamsContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_params);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(52);
			param();
			setState(57);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(53);
				match(COMMA);
				setState(54);
				param();
				}
				}
				setState(59);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParamContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(MiniCParser.ID, 0); }
		public TerminalNode ASSIGN() { return getToken(MiniCParser.ASSIGN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ParamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_param; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).enterParam(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).exitParam(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniCVisitor ) return ((MiniCVisitor<? extends T>)visitor).visitParam(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParamContext param() throws RecognitionException {
		ParamContext _localctx = new ParamContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_param);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(60);
			type();
			setState(61);
			match(ID);
			setState(64);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ASSIGN) {
				{
				setState(62);
				match(ASSIGN);
				setState(63);
				expr(0);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(MiniCParser.INT, 0); }
		public TerminalNode CHAR() { return getToken(MiniCParser.CHAR, 0); }
		public TerminalNode BOOL() { return getToken(MiniCParser.BOOL, 0); }
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).exitType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniCVisitor ) return ((MiniCVisitor<? extends T>)visitor).visitType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(66);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << CHAR) | (1L << BOOL))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BlockContext extends ParserRuleContext {
		public TerminalNode LBRACE() { return getToken(MiniCParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(MiniCParser.RBRACE, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).enterBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).exitBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniCVisitor ) return ((MiniCVisitor<? extends T>)visitor).visitBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(68);
			match(LBRACE);
			setState(72);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << CHAR) | (1L << BOOL) | (1L << IF) | (1L << WHILE) | (1L << FOR) | (1L << RETURN) | (1L << PRINTF) | (1L << SCANF) | (1L << TRUE) | (1L << FALSE) | (1L << MINUS) | (1L << NOT) | (1L << SEMI) | (1L << LPAREN) | (1L << LBRACE) | (1L << ID) | (1L << NUMBER) | (1L << CHAR_LITERAL))) != 0)) {
				{
				{
				setState(69);
				statement();
				}
				}
				setState(74);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(75);
			match(RBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatementContext extends ParserRuleContext {
		public VarDeclContext varDecl() {
			return getRuleContext(VarDeclContext.class,0);
		}
		public ExprStContext exprSt() {
			return getRuleContext(ExprStContext.class,0);
		}
		public IfStContext ifSt() {
			return getRuleContext(IfStContext.class,0);
		}
		public WhileStContext whileSt() {
			return getRuleContext(WhileStContext.class,0);
		}
		public ForStContext forSt() {
			return getRuleContext(ForStContext.class,0);
		}
		public ReturnStContext returnSt() {
			return getRuleContext(ReturnStContext.class,0);
		}
		public IoStContext ioSt() {
			return getRuleContext(IoStContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).exitStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniCVisitor ) return ((MiniCVisitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_statement);
		try {
			setState(85);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT:
			case CHAR:
			case BOOL:
				enterOuterAlt(_localctx, 1);
				{
				setState(77);
				varDecl();
				}
				break;
			case TRUE:
			case FALSE:
			case MINUS:
			case NOT:
			case SEMI:
			case LPAREN:
			case ID:
			case NUMBER:
			case CHAR_LITERAL:
				enterOuterAlt(_localctx, 2);
				{
				setState(78);
				exprSt();
				}
				break;
			case IF:
				enterOuterAlt(_localctx, 3);
				{
				setState(79);
				ifSt();
				}
				break;
			case WHILE:
				enterOuterAlt(_localctx, 4);
				{
				setState(80);
				whileSt();
				}
				break;
			case FOR:
				enterOuterAlt(_localctx, 5);
				{
				setState(81);
				forSt();
				}
				break;
			case RETURN:
				enterOuterAlt(_localctx, 6);
				{
				setState(82);
				returnSt();
				}
				break;
			case PRINTF:
			case SCANF:
				enterOuterAlt(_localctx, 7);
				{
				setState(83);
				ioSt();
				}
				break;
			case LBRACE:
				enterOuterAlt(_localctx, 8);
				{
				setState(84);
				block();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExprStContext extends ParserRuleContext {
		public TerminalNode SEMI() { return getToken(MiniCParser.SEMI, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ExprStContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exprSt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).enterExprSt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).exitExprSt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniCVisitor ) return ((MiniCVisitor<? extends T>)visitor).visitExprSt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprStContext exprSt() throws RecognitionException {
		ExprStContext _localctx = new ExprStContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_exprSt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(88);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TRUE) | (1L << FALSE) | (1L << MINUS) | (1L << NOT) | (1L << LPAREN) | (1L << ID) | (1L << NUMBER) | (1L << CHAR_LITERAL))) != 0)) {
				{
				setState(87);
				expr(0);
				}
			}

			setState(90);
			match(SEMI);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IfStContext extends ParserRuleContext {
		public TerminalNode IF() { return getToken(MiniCParser.IF, 0); }
		public TerminalNode LPAREN() { return getToken(MiniCParser.LPAREN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(MiniCParser.RPAREN, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public TerminalNode ELSE() { return getToken(MiniCParser.ELSE, 0); }
		public IfStContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifSt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).enterIfSt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).exitIfSt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniCVisitor ) return ((MiniCVisitor<? extends T>)visitor).visitIfSt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfStContext ifSt() throws RecognitionException {
		IfStContext _localctx = new IfStContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_ifSt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(92);
			match(IF);
			setState(93);
			match(LPAREN);
			setState(94);
			expr(0);
			setState(95);
			match(RPAREN);
			setState(96);
			statement();
			setState(99);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				{
				setState(97);
				match(ELSE);
				setState(98);
				statement();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class WhileStContext extends ParserRuleContext {
		public TerminalNode WHILE() { return getToken(MiniCParser.WHILE, 0); }
		public TerminalNode LPAREN() { return getToken(MiniCParser.LPAREN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(MiniCParser.RPAREN, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public WhileStContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whileSt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).enterWhileSt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).exitWhileSt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniCVisitor ) return ((MiniCVisitor<? extends T>)visitor).visitWhileSt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WhileStContext whileSt() throws RecognitionException {
		WhileStContext _localctx = new WhileStContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_whileSt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(101);
			match(WHILE);
			setState(102);
			match(LPAREN);
			setState(103);
			expr(0);
			setState(104);
			match(RPAREN);
			setState(105);
			statement();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ForStContext extends ParserRuleContext {
		public TerminalNode FOR() { return getToken(MiniCParser.FOR, 0); }
		public TerminalNode LPAREN() { return getToken(MiniCParser.LPAREN, 0); }
		public List<TerminalNode> SEMI() { return getTokens(MiniCParser.SEMI); }
		public TerminalNode SEMI(int i) {
			return getToken(MiniCParser.SEMI, i);
		}
		public TerminalNode RPAREN() { return getToken(MiniCParser.RPAREN, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public VarDeclContext varDecl() {
			return getRuleContext(VarDeclContext.class,0);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public ForStContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forSt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).enterForSt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).exitForSt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniCVisitor ) return ((MiniCVisitor<? extends T>)visitor).visitForSt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ForStContext forSt() throws RecognitionException {
		ForStContext _localctx = new ForStContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_forSt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(107);
			match(FOR);
			setState(108);
			match(LPAREN);
			setState(114);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT:
			case CHAR:
			case BOOL:
				{
				setState(109);
				varDecl();
				}
				break;
			case TRUE:
			case FALSE:
			case MINUS:
			case NOT:
			case SEMI:
			case LPAREN:
			case ID:
			case NUMBER:
			case CHAR_LITERAL:
				{
				setState(111);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TRUE) | (1L << FALSE) | (1L << MINUS) | (1L << NOT) | (1L << LPAREN) | (1L << ID) | (1L << NUMBER) | (1L << CHAR_LITERAL))) != 0)) {
					{
					setState(110);
					expr(0);
					}
				}

				setState(113);
				match(SEMI);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(117);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TRUE) | (1L << FALSE) | (1L << MINUS) | (1L << NOT) | (1L << LPAREN) | (1L << ID) | (1L << NUMBER) | (1L << CHAR_LITERAL))) != 0)) {
				{
				setState(116);
				expr(0);
				}
			}

			setState(119);
			match(SEMI);
			setState(121);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TRUE) | (1L << FALSE) | (1L << MINUS) | (1L << NOT) | (1L << LPAREN) | (1L << ID) | (1L << NUMBER) | (1L << CHAR_LITERAL))) != 0)) {
				{
				setState(120);
				expr(0);
				}
			}

			setState(123);
			match(RPAREN);
			setState(124);
			statement();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ReturnStContext extends ParserRuleContext {
		public TerminalNode RETURN() { return getToken(MiniCParser.RETURN, 0); }
		public TerminalNode SEMI() { return getToken(MiniCParser.SEMI, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ReturnStContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnSt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).enterReturnSt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).exitReturnSt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniCVisitor ) return ((MiniCVisitor<? extends T>)visitor).visitReturnSt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReturnStContext returnSt() throws RecognitionException {
		ReturnStContext _localctx = new ReturnStContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_returnSt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(126);
			match(RETURN);
			setState(128);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TRUE) | (1L << FALSE) | (1L << MINUS) | (1L << NOT) | (1L << LPAREN) | (1L << ID) | (1L << NUMBER) | (1L << CHAR_LITERAL))) != 0)) {
				{
				setState(127);
				expr(0);
				}
			}

			setState(130);
			match(SEMI);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IoStContext extends ParserRuleContext {
		public TerminalNode PRINTF() { return getToken(MiniCParser.PRINTF, 0); }
		public TerminalNode LPAREN() { return getToken(MiniCParser.LPAREN, 0); }
		public TerminalNode STRING() { return getToken(MiniCParser.STRING, 0); }
		public TerminalNode RPAREN() { return getToken(MiniCParser.RPAREN, 0); }
		public TerminalNode SEMI() { return getToken(MiniCParser.SEMI, 0); }
		public List<TerminalNode> COMMA() { return getTokens(MiniCParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(MiniCParser.COMMA, i);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode SCANF() { return getToken(MiniCParser.SCANF, 0); }
		public List<TerminalNode> ID() { return getTokens(MiniCParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(MiniCParser.ID, i);
		}
		public IoStContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ioSt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).enterIoSt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).exitIoSt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniCVisitor ) return ((MiniCVisitor<? extends T>)visitor).visitIoSt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IoStContext ioSt() throws RecognitionException {
		IoStContext _localctx = new IoStContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_ioSt);
		int _la;
		try {
			setState(156);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case PRINTF:
				enterOuterAlt(_localctx, 1);
				{
				setState(132);
				match(PRINTF);
				setState(133);
				match(LPAREN);
				setState(134);
				match(STRING);
				setState(139);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(135);
					match(COMMA);
					setState(136);
					expr(0);
					}
					}
					setState(141);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(142);
				match(RPAREN);
				setState(143);
				match(SEMI);
				}
				break;
			case SCANF:
				enterOuterAlt(_localctx, 2);
				{
				setState(144);
				match(SCANF);
				setState(145);
				match(LPAREN);
				setState(146);
				match(STRING);
				setState(151);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(147);
					match(COMMA);
					setState(148);
					match(ID);
					}
					}
					setState(153);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(154);
				match(RPAREN);
				setState(155);
				match(SEMI);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExprContext extends ParserRuleContext {
		public Token op;
		public TerminalNode ID() { return getToken(MiniCParser.ID, 0); }
		public TerminalNode ASSIGN() { return getToken(MiniCParser.ASSIGN, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode NOT() { return getToken(MiniCParser.NOT, 0); }
		public TerminalNode MINUS() { return getToken(MiniCParser.MINUS, 0); }
		public TerminalNode LPAREN() { return getToken(MiniCParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(MiniCParser.RPAREN, 0); }
		public TerminalNode NUMBER() { return getToken(MiniCParser.NUMBER, 0); }
		public TerminalNode CHAR_LITERAL() { return getToken(MiniCParser.CHAR_LITERAL, 0); }
		public TerminalNode TRUE() { return getToken(MiniCParser.TRUE, 0); }
		public TerminalNode FALSE() { return getToken(MiniCParser.FALSE, 0); }
		public FunctionCallContext functionCall() {
			return getRuleContext(FunctionCallContext.class,0);
		}
		public TerminalNode MULT() { return getToken(MiniCParser.MULT, 0); }
		public TerminalNode DIV() { return getToken(MiniCParser.DIV, 0); }
		public TerminalNode MOD() { return getToken(MiniCParser.MOD, 0); }
		public TerminalNode PLUS() { return getToken(MiniCParser.PLUS, 0); }
		public TerminalNode LT() { return getToken(MiniCParser.LT, 0); }
		public TerminalNode LE() { return getToken(MiniCParser.LE, 0); }
		public TerminalNode GT() { return getToken(MiniCParser.GT, 0); }
		public TerminalNode GE() { return getToken(MiniCParser.GE, 0); }
		public TerminalNode EQ() { return getToken(MiniCParser.EQ, 0); }
		public TerminalNode NEQ() { return getToken(MiniCParser.NEQ, 0); }
		public TerminalNode OR() { return getToken(MiniCParser.OR, 0); }
		public TerminalNode AND() { return getToken(MiniCParser.AND, 0); }
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).exitExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniCVisitor ) return ((MiniCVisitor<? extends T>)visitor).visitExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 26;
		enterRecursionRule(_localctx, 26, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(174);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				{
				setState(159);
				match(ID);
				setState(160);
				match(ASSIGN);
				setState(161);
				expr(9);
				}
				break;
			case 2:
				{
				setState(162);
				_la = _input.LA(1);
				if ( !(_la==MINUS || _la==NOT) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(163);
				expr(8);
				}
				break;
			case 3:
				{
				setState(164);
				match(LPAREN);
				setState(165);
				expr(0);
				setState(166);
				match(RPAREN);
				}
				break;
			case 4:
				{
				setState(168);
				match(ID);
				}
				break;
			case 5:
				{
				setState(169);
				match(NUMBER);
				}
				break;
			case 6:
				{
				setState(170);
				match(CHAR_LITERAL);
				}
				break;
			case 7:
				{
				setState(171);
				match(TRUE);
				}
				break;
			case 8:
				{
				setState(172);
				match(FALSE);
				}
				break;
			case 9:
				{
				setState(173);
				functionCall();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(199);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(197);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
					case 1:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(176);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(177);
						((ExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MULT) | (1L << DIV) | (1L << MOD))) != 0)) ) {
							((ExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(178);
						expr(17);
						}
						break;
					case 2:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(179);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(180);
						((ExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==PLUS || _la==MINUS) ) {
							((ExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(181);
						expr(16);
						}
						break;
					case 3:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(182);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(183);
						((ExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__0 || _la==T__1) ) {
							((ExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(184);
						expr(15);
						}
						break;
					case 4:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(185);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(186);
						((ExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LT) | (1L << GT) | (1L << LE) | (1L << GE))) != 0)) ) {
							((ExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(187);
						expr(14);
						}
						break;
					case 5:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(188);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(189);
						((ExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==EQ || _la==NEQ) ) {
							((ExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(190);
						expr(13);
						}
						break;
					case 6:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(191);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(192);
						((ExprContext)_localctx).op = match(OR);
						setState(193);
						expr(12);
						}
						break;
					case 7:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(194);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(195);
						((ExprContext)_localctx).op = match(AND);
						setState(196);
						expr(11);
						}
						break;
					}
					} 
				}
				setState(201);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class FunctionCallContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(MiniCParser.ID, 0); }
		public TerminalNode LPAREN() { return getToken(MiniCParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(MiniCParser.RPAREN, 0); }
		public ArgsContext args() {
			return getRuleContext(ArgsContext.class,0);
		}
		public FunctionCallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionCall; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).enterFunctionCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).exitFunctionCall(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniCVisitor ) return ((MiniCVisitor<? extends T>)visitor).visitFunctionCall(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionCallContext functionCall() throws RecognitionException {
		FunctionCallContext _localctx = new FunctionCallContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_functionCall);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(202);
			match(ID);
			setState(203);
			match(LPAREN);
			setState(205);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TRUE) | (1L << FALSE) | (1L << MINUS) | (1L << NOT) | (1L << LPAREN) | (1L << ID) | (1L << NUMBER) | (1L << CHAR_LITERAL))) != 0)) {
				{
				setState(204);
				args();
				}
			}

			setState(207);
			match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArgsContext extends ParserRuleContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(MiniCParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(MiniCParser.COMMA, i);
		}
		public ArgsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_args; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).enterArgs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).exitArgs(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniCVisitor ) return ((MiniCVisitor<? extends T>)visitor).visitArgs(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArgsContext args() throws RecognitionException {
		ArgsContext _localctx = new ArgsContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_args);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(209);
			expr(0);
			setState(214);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(210);
				match(COMMA);
				setState(211);
				expr(0);
				}
				}
				setState(216);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VarDeclContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(MiniCParser.ID, 0); }
		public TerminalNode SEMI() { return getToken(MiniCParser.SEMI, 0); }
		public TerminalNode ASSIGN() { return getToken(MiniCParser.ASSIGN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public VarDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).enterVarDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).exitVarDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniCVisitor ) return ((MiniCVisitor<? extends T>)visitor).visitVarDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarDeclContext varDecl() throws RecognitionException {
		VarDeclContext _localctx = new VarDeclContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_varDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(217);
			type();
			setState(218);
			match(ID);
			setState(221);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ASSIGN) {
				{
				setState(219);
				match(ASSIGN);
				setState(220);
				expr(0);
				}
			}

			setState(223);
			match(SEMI);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 13:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 16);
		case 1:
			return precpred(_ctx, 15);
		case 2:
			return precpred(_ctx, 14);
		case 3:
			return precpred(_ctx, 13);
		case 4:
			return precpred(_ctx, 12);
		case 5:
			return precpred(_ctx, 11);
		case 6:
			return precpred(_ctx, 10);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3*\u00e4\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\3\2\3\2\7\2\'\n\2\f\2\16\2*\13\2\3\2\3\2\3\3\3\3\3\3\3\3\5\3\62\n\3\3"+
		"\3\3\3\3\3\3\4\3\4\3\4\7\4:\n\4\f\4\16\4=\13\4\3\5\3\5\3\5\3\5\5\5C\n"+
		"\5\3\6\3\6\3\7\3\7\7\7I\n\7\f\7\16\7L\13\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b"+
		"\3\b\3\b\3\b\5\bX\n\b\3\t\5\t[\n\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n"+
		"\5\nf\n\n\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\5\fr\n\f\3\f\5"+
		"\fu\n\f\3\f\5\fx\n\f\3\f\3\f\5\f|\n\f\3\f\3\f\3\f\3\r\3\r\5\r\u0083\n"+
		"\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\7\16\u008c\n\16\f\16\16\16\u008f\13"+
		"\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\7\16\u0098\n\16\f\16\16\16\u009b"+
		"\13\16\3\16\3\16\5\16\u009f\n\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3"+
		"\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\5\17\u00b1\n\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\7\17\u00c8\n\17\f\17\16\17\u00cb\13\17\3\20"+
		"\3\20\3\20\5\20\u00d0\n\20\3\20\3\20\3\21\3\21\3\21\7\21\u00d7\n\21\f"+
		"\21\16\21\u00da\13\21\3\22\3\22\3\22\3\22\5\22\u00e0\n\22\3\22\3\22\3"+
		"\22\2\3\34\23\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"\2\t\3\2\5\7\4"+
		"\2\22\22\37\37\3\2\23\25\3\2\21\22\3\2\3\4\3\2\31\34\3\2\27\30\2\u00fb"+
		"\2(\3\2\2\2\4-\3\2\2\2\6\66\3\2\2\2\b>\3\2\2\2\nD\3\2\2\2\fF\3\2\2\2\16"+
		"W\3\2\2\2\20Z\3\2\2\2\22^\3\2\2\2\24g\3\2\2\2\26m\3\2\2\2\30\u0080\3\2"+
		"\2\2\32\u009e\3\2\2\2\34\u00b0\3\2\2\2\36\u00cc\3\2\2\2 \u00d3\3\2\2\2"+
		"\"\u00db\3\2\2\2$\'\5\4\3\2%\'\5\"\22\2&$\3\2\2\2&%\3\2\2\2\'*\3\2\2\2"+
		"(&\3\2\2\2()\3\2\2\2)+\3\2\2\2*(\3\2\2\2+,\7\2\2\3,\3\3\2\2\2-.\5\n\6"+
		"\2./\7&\2\2/\61\7\"\2\2\60\62\5\6\4\2\61\60\3\2\2\2\61\62\3\2\2\2\62\63"+
		"\3\2\2\2\63\64\7#\2\2\64\65\5\f\7\2\65\5\3\2\2\2\66;\5\b\5\2\678\7!\2"+
		"\28:\5\b\5\29\67\3\2\2\2:=\3\2\2\2;9\3\2\2\2;<\3\2\2\2<\7\3\2\2\2=;\3"+
		"\2\2\2>?\5\n\6\2?B\7&\2\2@A\7\26\2\2AC\5\34\17\2B@\3\2\2\2BC\3\2\2\2C"+
		"\t\3\2\2\2DE\t\2\2\2E\13\3\2\2\2FJ\7$\2\2GI\5\16\b\2HG\3\2\2\2IL\3\2\2"+
		"\2JH\3\2\2\2JK\3\2\2\2KM\3\2\2\2LJ\3\2\2\2MN\7%\2\2N\r\3\2\2\2OX\5\"\22"+
		"\2PX\5\20\t\2QX\5\22\n\2RX\5\24\13\2SX\5\26\f\2TX\5\30\r\2UX\5\32\16\2"+
		"VX\5\f\7\2WO\3\2\2\2WP\3\2\2\2WQ\3\2\2\2WR\3\2\2\2WS\3\2\2\2WT\3\2\2\2"+
		"WU\3\2\2\2WV\3\2\2\2X\17\3\2\2\2Y[\5\34\17\2ZY\3\2\2\2Z[\3\2\2\2[\\\3"+
		"\2\2\2\\]\7 \2\2]\21\3\2\2\2^_\7\b\2\2_`\7\"\2\2`a\5\34\17\2ab\7#\2\2"+
		"be\5\16\b\2cd\7\t\2\2df\5\16\b\2ec\3\2\2\2ef\3\2\2\2f\23\3\2\2\2gh\7\n"+
		"\2\2hi\7\"\2\2ij\5\34\17\2jk\7#\2\2kl\5\16\b\2l\25\3\2\2\2mn\7\13\2\2"+
		"nt\7\"\2\2ou\5\"\22\2pr\5\34\17\2qp\3\2\2\2qr\3\2\2\2rs\3\2\2\2su\7 \2"+
		"\2to\3\2\2\2tq\3\2\2\2uw\3\2\2\2vx\5\34\17\2wv\3\2\2\2wx\3\2\2\2xy\3\2"+
		"\2\2y{\7 \2\2z|\5\34\17\2{z\3\2\2\2{|\3\2\2\2|}\3\2\2\2}~\7#\2\2~\177"+
		"\5\16\b\2\177\27\3\2\2\2\u0080\u0082\7\f\2\2\u0081\u0083\5\34\17\2\u0082"+
		"\u0081\3\2\2\2\u0082\u0083\3\2\2\2\u0083\u0084\3\2\2\2\u0084\u0085\7 "+
		"\2\2\u0085\31\3\2\2\2\u0086\u0087\7\r\2\2\u0087\u0088\7\"\2\2\u0088\u008d"+
		"\7)\2\2\u0089\u008a\7!\2\2\u008a\u008c\5\34\17\2\u008b\u0089\3\2\2\2\u008c"+
		"\u008f\3\2\2\2\u008d\u008b\3\2\2\2\u008d\u008e\3\2\2\2\u008e\u0090\3\2"+
		"\2\2\u008f\u008d\3\2\2\2\u0090\u0091\7#\2\2\u0091\u009f\7 \2\2\u0092\u0093"+
		"\7\16\2\2\u0093\u0094\7\"\2\2\u0094\u0099\7)\2\2\u0095\u0096\7!\2\2\u0096"+
		"\u0098\7&\2\2\u0097\u0095\3\2\2\2\u0098\u009b\3\2\2\2\u0099\u0097\3\2"+
		"\2\2\u0099\u009a\3\2\2\2\u009a\u009c\3\2\2\2\u009b\u0099\3\2\2\2\u009c"+
		"\u009d\7#\2\2\u009d\u009f\7 \2\2\u009e\u0086\3\2\2\2\u009e\u0092\3\2\2"+
		"\2\u009f\33\3\2\2\2\u00a0\u00a1\b\17\1\2\u00a1\u00a2\7&\2\2\u00a2\u00a3"+
		"\7\26\2\2\u00a3\u00b1\5\34\17\13\u00a4\u00a5\t\3\2\2\u00a5\u00b1\5\34"+
		"\17\n\u00a6\u00a7\7\"\2\2\u00a7\u00a8\5\34\17\2\u00a8\u00a9\7#\2\2\u00a9"+
		"\u00b1\3\2\2\2\u00aa\u00b1\7&\2\2\u00ab\u00b1\7\'\2\2\u00ac\u00b1\7(\2"+
		"\2\u00ad\u00b1\7\17\2\2\u00ae\u00b1\7\20\2\2\u00af\u00b1\5\36\20\2\u00b0"+
		"\u00a0\3\2\2\2\u00b0\u00a4\3\2\2\2\u00b0\u00a6\3\2\2\2\u00b0\u00aa\3\2"+
		"\2\2\u00b0\u00ab\3\2\2\2\u00b0\u00ac\3\2\2\2\u00b0\u00ad\3\2\2\2\u00b0"+
		"\u00ae\3\2\2\2\u00b0\u00af\3\2\2\2\u00b1\u00c9\3\2\2\2\u00b2\u00b3\f\22"+
		"\2\2\u00b3\u00b4\t\4\2\2\u00b4\u00c8\5\34\17\23\u00b5\u00b6\f\21\2\2\u00b6"+
		"\u00b7\t\5\2\2\u00b7\u00c8\5\34\17\22\u00b8\u00b9\f\20\2\2\u00b9\u00ba"+
		"\t\6\2\2\u00ba\u00c8\5\34\17\21\u00bb\u00bc\f\17\2\2\u00bc\u00bd\t\7\2"+
		"\2\u00bd\u00c8\5\34\17\20\u00be\u00bf\f\16\2\2\u00bf\u00c0\t\b\2\2\u00c0"+
		"\u00c8\5\34\17\17\u00c1\u00c2\f\r\2\2\u00c2\u00c3\7\36\2\2\u00c3\u00c8"+
		"\5\34\17\16\u00c4\u00c5\f\f\2\2\u00c5\u00c6\7\35\2\2\u00c6\u00c8\5\34"+
		"\17\r\u00c7\u00b2\3\2\2\2\u00c7\u00b5\3\2\2\2\u00c7\u00b8\3\2\2\2\u00c7"+
		"\u00bb\3\2\2\2\u00c7\u00be\3\2\2\2\u00c7\u00c1\3\2\2\2\u00c7\u00c4\3\2"+
		"\2\2\u00c8\u00cb\3\2\2\2\u00c9\u00c7\3\2\2\2\u00c9\u00ca\3\2\2\2\u00ca"+
		"\35\3\2\2\2\u00cb\u00c9\3\2\2\2\u00cc\u00cd\7&\2\2\u00cd\u00cf\7\"\2\2"+
		"\u00ce\u00d0\5 \21\2\u00cf\u00ce\3\2\2\2\u00cf\u00d0\3\2\2\2\u00d0\u00d1"+
		"\3\2\2\2\u00d1\u00d2\7#\2\2\u00d2\37\3\2\2\2\u00d3\u00d8\5\34\17\2\u00d4"+
		"\u00d5\7!\2\2\u00d5\u00d7\5\34\17\2\u00d6\u00d4\3\2\2\2\u00d7\u00da\3"+
		"\2\2\2\u00d8\u00d6\3\2\2\2\u00d8\u00d9\3\2\2\2\u00d9!\3\2\2\2\u00da\u00d8"+
		"\3\2\2\2\u00db\u00dc\5\n\6\2\u00dc\u00df\7&\2\2\u00dd\u00de\7\26\2\2\u00de"+
		"\u00e0\5\34\17\2\u00df\u00dd\3\2\2\2\u00df\u00e0\3\2\2\2\u00e0\u00e1\3"+
		"\2\2\2\u00e1\u00e2\7 \2\2\u00e2#\3\2\2\2\31&(\61;BJWZeqtw{\u0082\u008d"+
		"\u0099\u009e\u00b0\u00c7\u00c9\u00cf\u00d8\u00df";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}