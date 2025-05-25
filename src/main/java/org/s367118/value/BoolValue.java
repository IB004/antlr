package org.s367118.value;

public class BoolValue extends Value{
    public BoolValue(Boolean value){
        this.value = value;
    }

    private Boolean value;

    public Boolean getValue() {
        return value;
    }

    @Override
    public Value add(Value right) {
        return right.doAdd(this);
    }

    @Override
    public String represent() {
        return this.value.toString();
    }
}
