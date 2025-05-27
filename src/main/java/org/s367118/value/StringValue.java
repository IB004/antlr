package org.s367118.value;

public class StringValue extends Value{

    public StringValue(String value){
        this.value = value;
    }
    private String value;

    public String getValue() {
        return value;
    }


    // Operations definition for double dispatch
    @Override
    public Value add(Value right) {
        return right.doAdd(this);
    }
    @Override
    public Value eql(Value right) {
        return right.doEql(this);
    }


    // Concrete types operations support

    @Override
    public Value doAdd(IntValue left) {
        return new StringValue(left.represent() + this.getValue());
    }
    @Override
    public Value doAdd(StringValue left) {
        return new StringValue(left.getValue() + this.represent());
    }

    @Override
    public Value doEql(StringValue left) {
        return new BoolValue(left.getValue().equals(this.getValue()));
    }


    @Override
    public String represent() {
        return this.value.toString();
    }
}