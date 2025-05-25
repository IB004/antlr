package org.s367118.value;

public abstract class Value {
    public abstract Value add(Value right);

    public Value doAdd(IntValue left){
        throw new IllegalArgumentException();
    }
    public Value doAdd(BoolValue left){
        throw new IllegalArgumentException();
    }

    public Value doAdd(StringValue left){
        throw new IllegalArgumentException();
    }

    public abstract String represent();

}
