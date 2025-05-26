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
    public Value sub(Value right) {
        return right.doSub(this);
    }
    @Override
    public Value mul(Value right) {
        return right.doMul(this);
    }
    @Override
    public Value div(Value right) {
        return right.doDiv(this);
    }
    @Override
    public Value greater(Value right) {
        return right.doGreater(this);
    }
    @Override
    public Value less(Value right) {
        return right.doLess(this);
    }
    @Override
    public Value eql(Value right) {
        return right.doEql(this);
    }


    // Concrete types operations support

    @Override
    public Value doAdd(BoolValue left) {
        return new BoolValue(left.getValue() || this.getValue());
    }

    @Override
    public Value doMul(BoolValue left) {
        return new BoolValue(left.getValue() && this.getValue());
    }

    @Override
    public Value neg() {
        return new BoolValue(!this.getValue());
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
