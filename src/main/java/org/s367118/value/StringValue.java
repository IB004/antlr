package org.s367118.value;

public class StringValue extends Value{

    public StringValue(String value){
        this.value = value;
    }

    private String value;

    public String getValue() {
        return value;
    }

    @Override
    public Value add(Value right) {
        return right.doAdd(this);
    }

    @Override
    public Value doAdd(IntValue left) {
        return new StringValue(left.represent() + this.getValue());
    }

    @Override
    public String represent() {
        return this.value;
    }
}
