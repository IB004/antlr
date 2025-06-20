# Язык Scripty

`Scripty` -- это простой язык с `C`-подобным синтаксисом.

## Синтаксис языка

Всего поддерживается 4 базовых выражения:
- `ID = ... ;` -- присвоить переменной некоторое значение;
- `print( ... );` -- вывести значение на экран;
- `if( ... ) { ... } [else { ... }]` -- ветвление с факультативной ветвью `else`;
- `while( ... ) { ... }` -- цикл `while`.

В `if`, `else` и `while` можно опустить фигурные скобки, если далее следует единичное выражение.

Строчные комментарии вида `# ... `, а также пробельные символы игнорируются.

## Переменные и типы



Язык обладает слабой динамической типизацией. Рассмотрим основные особенности:

- переменные обладают глобальной областью видимости; 
- переменные могут хранить целые числа, вещественные числа, булевы значения и строки;
- тип переменных не указывается, а определяется присваиваемым значением;
- значение переменной может быть перезаписано вне зависимости от типа;

``` c
a = 42;
b = 11;
pi = 3.14;
t = true;
f = false;
s = "hello: ";
```

Рассмотрим особенности преобразования типов:
- при сложении любого типа со строкой получается строка;
- при операциях между целыми и вещественными числами результатом будет вещественное число;

```python
print(s + a);               # hello: 42
print(s + pi);              # hello: 3.14
print(s + t);               # hello: true
print(s + s);               # hello: hello:
print(s + "\"Scripty\"")    # hello: "Scripty"

print(---b);                # -11
print(-2 + a * 0.5);        # 19.0

print(a / b);               # 3.8181818
print(a // b);              # 3
print(a % b);               # 9

print(!t);                  # false
print(t && f);              # false
print(t || f);              # true
```

Выше также продемонстрированы основные операции, поддерживаемые языком.

## Примеры

### Поиск НОД

```c
a = 784;
b = 256;

_a = a;
_b = b;
while (!(_a == 0) && !(_b == 0)){
    if (_a > _b){
        _a = _a % _b;
        res = _b;
    }
    else{
        _b = _b % _a;
        res = _a;
    }
}

print("The greatest common divisor of " + a + " and " + b + " is " + res + ".");
```

```
The greatest common divisor of 784 and 256 is 16.
```

### Вычисление n-го члена последовательности Фибоначчи

```c
a1 = 0;
a2 = 1;
n = 29;

prev = a1;
curr = a2;
i = 2;
while (i < n){
    new = curr + prev;
    prev = curr;
    curr = new;
    i = i + 1;
}

print("The " + n + " element is " + curr + ".");
```

```
The 29 element is 317811.
```

## Ошибки

При возникновении ошибки программа выдает исключение или предупреждение. 

Пропуск `;`:
```c
a = 12
print(a);
```

```
line 2:0 missing ';' at 'print'
12
```

Использование неизвестной переменной:
```c
a = 1;
b = a + c;
print(b);
```

```
VariableIsNotDeclaredException: Variable 'c' was not declared.
```

Неожиданное пременение операторов:

```c
a = 4.2;
b = false;
print(a * b);
```

```
NotSupportedOperationException: FloatValue 'mul' BoolValue is not supported.
```






# Интерпретатор языка

Интерпреатор написан на языке `Java` с применением `ANTLR`. 

Грамматика Scripty описана в [Scripty.g4](./src/main/java/org/s367118/antlr/Scripty.g4).

Обработка узлов происходит в [EvalVisitor.java](./src/main/java/org/s367118/EvalVisitor.java).

Например, так выглядит обработка оператора присвоения:
```Java
    @Override
    public Value visitAssign(ScriptyParser.AssignContext ctx) {
        String id = ctx.ID().getText();
        Value value = visit(ctx.res());
        memory.put(id, value);
        return value;
    }
```

Переменные хранятся в общей `Map<String, Value>`. Каждый конкретный тип наследуется от `Value` и переопределяет поддерживаемые операции для желаемых типов: например, вещественные числа могут умножаться на своих собратьев по типу и на целые числа, но не на булевы выражения и не на строки. Управление, какая именно операция будет вызвана, осуществляется через двойную диспетчеризацию.