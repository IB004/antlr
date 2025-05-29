package org.s367118.value;

public abstract class Value {

    // ADD operation
    public Value add(Value right){
        throw new NotSupportedOperationException("add", this);
    };
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
    public Value sub(Value right){
        throw new NotSupportedOperationException("sub", this);
    };
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
    public Value mul(Value right){
        throw new NotSupportedOperationException("mul", this);
    };
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
    public Value div(Value right) {
        throw new NotSupportedOperationException("div", this);
    };
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

    public Value iDiv(Value right){
        throw new NotSupportedOperationException("idiv", this);
    };
    public Value doIDiv(IntValue left){
        throw new NotSupportedOperationException("idiv", left, this);
    }
    public Value doIDiv(FloatValue left){
        throw new NotSupportedOperationException("idiv", left, this);
    }
    public Value doIDiv(BoolValue left){
        throw new NotSupportedOperationException("idiv", left, this);
    }
    public Value doIDiv(StringValue left){
        throw new NotSupportedOperationException("idiv", left, this);
    }

    public Value mod(Value right){
        throw new NotSupportedOperationException("mod", this);
    };
    public Value doMod(IntValue left){
        throw new NotSupportedOperationException("mod", left, this);
    }
    public Value doMod(FloatValue left){
        throw new NotSupportedOperationException("mod", left, this);
    }
    public Value doMod(BoolValue left){
        throw new NotSupportedOperationException("mod", left, this);
    }
    public Value doMod(StringValue left){
        throw new NotSupportedOperationException("mod", left, this);
    }

    //NEG operation
    public Value neg(){
        throw new NotSupportedOperationException("neg", this);
    }

    // AND operation
    public Value and(Value right){
        throw new NotSupportedOperationException("and", this);
    };
    public Value doAnd(IntValue left){
        throw new NotSupportedOperationException("and", left, this);
    }
    public Value doAnd(FloatValue left){
        throw new NotSupportedOperationException("and", left, this);
    }
    public Value doAnd(BoolValue left){
        throw new NotSupportedOperationException("and", left, this);
    }
    public Value doAnd(StringValue left){
        throw new NotSupportedOperationException("and", left, this);
    }

    // OR operation
    public Value or(Value right){
        throw new NotSupportedOperationException("add", this);
    };
    public Value doOr(IntValue left){
        throw new NotSupportedOperationException("or", left, this);
    }
    public Value doOr(FloatValue left){
        throw new NotSupportedOperationException("or", left, this);
    }
    public Value doOr(BoolValue left){
        throw new NotSupportedOperationException("or", left, this);
    }
    public Value doOr(StringValue left){
        throw new NotSupportedOperationException("or", left, this);
    }

    //NOT operation
    public Value not(){
        throw new NotSupportedOperationException("not", this);
    }



    //GRT operation
    public Value greater(Value right){
        throw new NotSupportedOperationException("grt", this);
    };
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
    public Value less(Value right){
        throw new NotSupportedOperationException("less", this);
    };
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
    public Value eql(Value right){
        throw new NotSupportedOperationException("eql", this);
    };
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
