package org.s367118.value;

public class IntValue extends Value{

    public IntValue(Integer value){
        this.value = value;
    }

    private Integer value;

    public Integer getValue() {
        return value;
    }

    @Override
    public Value add(Value right) {
        return right.doAdd(this);
    }

    @Override
    public Value doAdd(IntValue left) {
        return new IntValue(left.getValue() + this.getValue());
    }

    @Override
    public Value doAdd(StringValue left) {
        return new StringValue(left.getValue() + this.represent());
    }

    @Override
    public String represent() {
        return this.value.toString();
    }
}
