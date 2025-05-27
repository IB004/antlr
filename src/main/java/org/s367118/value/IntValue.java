package org.s367118.value;

public class IntValue extends Value{

    public IntValue(Integer value){
        this.value = value;
    }
    private Integer value;

    public Integer getValue() {
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
    public Value doAdd(IntValue left) {
        return new IntValue(left.getValue() + this.getValue());
    }
    @Override
    public Value doAdd(FloatValue left) {
        return new FloatValue(left.getValue() + this.getValue());
    }
    @Override
    public Value doAdd(StringValue left) {
        return new StringValue(left.getValue() + this.represent());
    }

    @Override
    public Value doSub(IntValue left) {
        return new IntValue(left.getValue() - this.getValue());
    }
    @Override
    public Value doSub(FloatValue left) {
        return new FloatValue(left.getValue() - this.getValue());
    }

    @Override
    public Value doMul(IntValue left) {
        return new IntValue(left.getValue() * this.getValue());
    }
    @Override
    public Value doMul(FloatValue left) {
        return new FloatValue(left.getValue() * this.getValue());
    }

    @Override
    public Value doDiv(IntValue left) {
        return new FloatValue(left.getValue().floatValue() / this.getValue());
    }
    @Override
    public Value doDiv(FloatValue left) {
        return new FloatValue(left.getValue() / this.getValue());
    }

    @Override
    public Value neg() {
        return new IntValue(-this.getValue());
    }

    @Override
    public Value doGreater(IntValue left) {
        return new BoolValue(left.getValue() > this.getValue());
    }
    @Override
    public Value doGreater(FloatValue left) {
        return new BoolValue(left.getValue() > this.getValue());
    }

    @Override
    public Value doLess(IntValue left) {
        return new BoolValue(left.getValue() < this.getValue());
    }
    @Override
    public Value doLess(FloatValue left) {
        return new BoolValue(left.getValue() < this.getValue());
    }

    @Override
    public Value doEql(IntValue left) {
        return new BoolValue(left.getValue().equals(this.getValue()));
    }
    @Override
    public Value doEql(FloatValue left) {
        return new BoolValue(left.getValue().equals(this.getValue().floatValue()));
    }


    @Override
    public String represent() {
        return this.value.toString();
    }
}
