grammar MiniC;

//========== lexer Rules (Tokens) ===============

INT : 'int';
CHAR : 'char';
BOOL : 'bool';
IF : 'if';
ELSE : 'else';
WHILE : 'while';
FOR : 'for';
RETURN : 'return';
PRINTF : 'printf';
SCANF : 'scanf';
TRUE : 'true';
FALSE : 'false';
PLUS : '+';
MINUS : '-';
MULT : '*';
DIV : '/';
MOD : '%';
ASSIGN : '=';
EQ : '==';
NEQ : '!=';
LT : '<';
GT : '>';
LE : '<=';
GE : '>=';
AND : '&&';
OR : '||';
NOT : '!';
SEMI : ';';
COMMA : ',';
LPAREN : '(';
RPAREN : ')';
LBRACE : '{';
RBRACE : '}';
ID : [a-zA-Z_][a-zA-Z0-9_]*;
NUMBER : [0-9]+;
CHAR_LITERAL : '\'' . '\'';
STRING : '"' .*? '"';
WS : [ \t\r\n]+ -> skip;


//====================parser rules ==============

program
    : (functionDecl | varDecl)* EOF
    ;

functionDecl
    : type ID LPAREN params? RPAREN block
    ;

params
    :param (COMMA param)*
    ;

param
    : type ID (ASSIGN expr)?
    ;

type
    : INT
    | CHAR
    | BOOL
    ;

block
    : LBRACE statement* RBRACE
    ;

statement
    : varDecl
    | exprSt
    | ifSt
    | whileSt
    | forSt
    | returnSt
    | ioSt
    | block
    ;

exprSt
    : expr? SEMI
    ;

ifSt
    : IF LPAREN expr RPAREN statement (ELSE statement)?
    ;

whileSt
    : WHILE LPAREN expr RPAREN statement
    ;

forSt
    : FOR LPAREN exprSt exprSt expr? RPAREN statement
    ;

returnSt
    : RETURN expr? SEMI
    ;

ioSt
    : PRINTF LPAREN STRING (COMMA expr)* RPAREN SEMI
    | SCANF LPAREN STRING (COMMA ID)* RPAREN SEMI
    ;

expr
    : expr op=('*' | '/' | '%') expr
    | expr op=('+' | '-') expr
    | expr op=('<' | '<=' | '>' | '>=') expr
    | expr op=('==' | '!=') expr
    | expr op=OR expr
    | expr op=AND expr
    | ID ASSIGN expr
    | NOT expr
    | LPAREN expr RPAREN
    | ID
    | NUMBER
    | CHAR_LITERAL
    | TRUE
    | FALSE
    | functionCall
    ;

functionCall
    : ID LPAREN args? RPAREN
    ;

args
    : expr (COMMA expr)*
    ;

 varDecl
     : type ID (ASSIGN expr)? SEMI
     ;