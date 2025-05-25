grammar LabeledExpr; // rename to distinguish from Expr.g4

prog:   stat+ ;

stat:   expr NEWLINE               # printExpr
    |   ID ASSIGN res NEWLINE      # assign
    |   NEWLINE                    # blank
    ;

res:    prop | expr;

prop:   expr op=(GRT|LES|EQL) expr  # Compare
    |   prop AND prop               # And
    |   prop OR prop                # Or
    |   TRUE                        # True
    |   FALSE                       # False
    |   ID                          # PropId
    |   '(' prop ')'                # PropParens
    ;

expr:   expr op=(MUL|DIV) expr      # MulDiv
    |   expr op=(ADD|SUB) expr      # AddSub
    |   SUB expr                    # UnaryMinus
    |   INT                         # int
    |   ID                          # id
    |   '(' expr ')'                # parens
    ;


MUL :   '*' ; // assigns token name to '*' used above in grammar
DIV :   '/' ;
ADD :   '+' ;
SUB :   '-' ;

GRT:    '>';
LES:    '<';
EQL:    '==';

AND:    '&&';
OR:     '||';

ASSIGN: '=';

INT_T:  'int';
BOOL_T: 'bool';

TRUE: 'true';
FALSE: 'false';

ID  :   [a-zA-Z_][a-zA-Z0-9_]*;      // match identifiers
INT :   [0-9]+ ;         // match integers

NEWLINE:'\r'? '\n' ;     // return newlines to parser (is end-statement signal)
WS  :   [ \t]+ -> skip ; // toss out whitespace
