grammar Language;

prog:   stat* ;

stat:   print END
    |   while
    |   if
    |   assign END
    ;

print:  PRINT '(' res ')';

assign: ID ASSIGN res;

while:  WHILE '(' prop ')' block;

block:  stat | '{' stat* '}';

if:     IF '(' prop ')' body=block (ELSE alter=block)?;

res:    prop | expr;

prop:   expr op=(GRT|LES|EQL) expr  # Compare
    |   NOT prop                    # Not
    |   prop AND prop               # And
    |   prop OR prop                # Or
    |   TRUE                        # True
    |   FALSE                       # False
    |   ID                          # PropId
    |   '(' prop ')'                # PropParens
    ;

expr:   SUB expr                    # UnaryMinus
    |   expr op=(MUL|DIV) expr      # MulDiv
    |   expr op=(ADD|SUB) expr      # AddSub
    |   INT                         # Int
    |   FLOAT                       # Float
    |   ID                          # Id
    |   STRING                      # String
    |   '(' expr ')'                # Parens
    ;


MUL     :   '*' ;
DIV     :   '/' ;
ADD     :   '+' ;
SUB     :   '-' ;

GRT     :   '>' ;
LES     :   '<' ;
EQL     :   '==' ;

AND     :   '&&' ;
OR      :   '||' ;
NOT     :   '!' ;

ASSIGN  :   '=' ;

INT_T   :   'int' ;
FLOAT_T :   'float' ;
BOOL_T  :   'bool' ;
STRING_T:   'string' ;

PRINT   :   'print' ;
WHILE   :   'while' ;
IF      :   'if' ;
ELSE    :   'else' ;

ID      :   [a-zA-Z_][a-zA-Z0-9_]* ;
INT     :   [+-]?[0-9]+ ;
FLOAT   :   [+-]?[0-9]*'.'[0-9]+ ;
TRUE    :   'true' ;
FALSE   :   'false' ;
STRING  :   '"' ('\\"' | ~["\r\n])* '"' ;

END     :   ';' ;
WS      :   [ \t\n\r]+ -> skip ;
COMMENT :   '//' ~[\r\n]* '\r'? '\n' -> skip ;