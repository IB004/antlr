grammar Scripty;

prog:   stat* ;

stat:   assign END
    |   print END
    |   if
    |   while
    ;

assign: ID ASSIGN res ;

print:  PRINT '(' res ')' ;

if:     IF '(' prop ')' main=block (ELSE alter=block)? ;

while:  WHILE '(' prop ')' block ;

block:  stat
    |   '{' stat* '}'
    ;

res:    prop
    |   expr
    ;

prop:   left=expr op=(GRT|LES|EQL) right=expr   # Compare
    |   NOT prop                                # Not
    |   left=prop AND right=prop                # And
    |   left=prop OR right=prop                 # Or
    |   TRUE                                    # True
    |   FALSE                                   # False
    |   ID                                      # PropId
    |   '(' prop ')'                            # PropParens
    ;

expr:   SUB expr                                        # UnaryMinus
    |   left=expr op=(MUL|DIV|IDIV|MOD) right=expr      # MulDiv
    |   left=expr op=(ADD|SUB) right=expr               # AddSub
    |   INT                                             # Int
    |   FLOAT                                           # Float
    |   STRING                                          # String
    |   ID                                              # Id
    |   '(' expr ')'                                    # Parens
    ;

ADD     :   '+' ;
SUB     :   '-' ;
MUL     :   '*' ;
DIV     :   '/' ;
MOD     :   '%' ;
IDIV    :   '//';

GRT     :   '>' ;
LES     :   '<' ;
EQL     :   '==' ;

AND     :   '&&' ;
OR      :   '||' ;
NOT     :   '!' ;

ASSIGN  :   '=' ;

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
COMMENT :   '#' ~[\r\n]* '\r'? '\n' -> skip ;