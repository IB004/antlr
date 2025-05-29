package org.s367118.value;

public class BoolValue extends Value{

    public BoolValue(Boolean value){
        this.value = value;
    }
    private Boolean value;

    public Boolean getValue() {
        return value;
    }


    // Operations definition for double dispatch
    @Override
    public Value add(Value right) {
        return right.doAdd(this);
    }
    @Override
    public Value not() {
        return new BoolValue(!this.value);
    }

    @Override
    public Value and(Value right) {
        return right.doAnd(this);
    }

    @Override
    public Value or(Value right) {
        return right.doOr(this);
    }
    @Override
    public Value eql(Value right) {
        return right.doEql(this);
    }


    // Concrete types operations support

    @Override
    public Value doAdd(StringValue left) {
        return new StringValue(left.getValue() + this.represent());
    }

    @Override
    public Value doAnd(BoolValue left) {
        return new BoolValue(left.getValue() && this.getValue());
    }

    @Override
    public Value doOr(BoolValue left) {
        return new BoolValue(left.getValue() || this.getValue());
    }


    @Override
    public Value doEql(BoolValue left) {
        return new BoolValue(left.getValue().equals(this.getValue()));
    }


    @Override
    public String represent() {
        return this.value.toString();
    }
}
