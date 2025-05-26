package org.s367118.value;

public abstract class Value {

    // ADD operation
    public abstract Value add(Value right);
    public Value doAdd(IntValue left){
        throw new NotSupportedOperationException("add", left, this);
    }
    public Value doAdd(FloatValue left){
        throw new NotSupportedOperationException("add", left, this);
    }
    public Value doAdd(BoolValue left){
        throw new NotSupportedOperationException("add", left, this);
    }
    public Value doAdd(StringValue left){
        throw new NotSupportedOperationException("add", left, this);
    }


    //SUB operation
    public abstract Value sub(Value right);
    public Value doSub(IntValue left){
        throw new NotSupportedOperationException("sub", left, this);
    }
    public Value doSub(FloatValue left){
        throw new NotSupportedOperationException("sub", left, this);
    }
    public Value doSub(BoolValue left){
        throw new NotSupportedOperationException("sub", left, this);
    }
    public Value doSub(StringValue left){
        throw new NotSupportedOperationException("sub", left, this);
    }


    //MUL operation
    public abstract Value mul(Value right);
    public Value doMul(IntValue left){
        throw new NotSupportedOperationException("mul", left, this);
    }
    public Value doMul(FloatValue left){
        throw new NotSupportedOperationException("mul", left, this);
    }
    public Value doMul(BoolValue left){
        throw new NotSupportedOperationException("mul", left, this);
    }
    public Value doMul(StringValue left){
        throw new NotSupportedOperationException("mul", left, this);
    }


    //DIV operation
    public abstract Value div(Value right);
    public Value doDiv(IntValue left){
        throw new NotSupportedOperationException("div", left, this);
    }
    public Value doDiv(FloatValue left){
        throw new NotSupportedOperationException("div", left, this);
    }
    public Value doDiv(BoolValue left){
        throw new NotSupportedOperationException("div", left, this);
    }
    public Value doDiv(StringValue left){
        throw new NotSupportedOperationException("div", left, this);
    }


    //NEG operation
    public Value neg(){
        throw new NotSupportedOperationException("neg", this);
    }


    //GRT operation
    public abstract Value greater(Value right);
    public Value doGreater(IntValue left){
        throw new NotSupportedOperationException("grt", left, this);
    }
    public Value doGreater(FloatValue left){
        throw new NotSupportedOperationException("grt", left, this);
    }
    public Value doGreater(BoolValue left){
        throw new NotSupportedOperationException("grt", left, this);
    }
    public Value doGreater(StringValue left){
        throw new NotSupportedOperationException("grt", left, this);
    }


    //LES operation
    public abstract Value less(Value right);
    public Value doLess(IntValue left){
        throw new NotSupportedOperationException("less", left, this);
    }
    public Value doLess(FloatValue left){
        throw new NotSupportedOperationException("less", left, this);
    }
    public Value doLess(BoolValue left){
        throw new NotSupportedOperationException("less", left, this);
    }
    public Value doLess(StringValue left){
        throw new NotSupportedOperationException("less", left, this);
    }



    //EQL operation
    public abstract Value eql(Value right);
    public Value doEql(IntValue left){
        throw new NotSupportedOperationException("eql", left, this);
    }
    public Value doEql(FloatValue left){
        throw new NotSupportedOperationException("eql", left, this);
    }
    public Value doEql(BoolValue left){
        throw new NotSupportedOperationException("eql", left, this);
    }
    public Value doEql(StringValue left){
        throw new NotSupportedOperationException("eql", left, this);
    }


    public abstract String represent();

}
