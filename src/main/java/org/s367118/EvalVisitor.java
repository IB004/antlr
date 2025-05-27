package org.s367118;

import org.s367118.antlr.ScriptyParser;
import org.s367118.antlr.ScriptyBaseVisitor;
import org.s367118.value.*;

import javax.annotation.processing.SupportedSourceVersion;
import java.util.HashMap;
import java.util.Map;

public class EvalVisitor extends ScriptyBaseVisitor<Value> {
    Map<String, Value> memory = new HashMap<>();

    
    
    @Override
    public Value visitAssign(ScriptyParser.AssignContext ctx) {
        String id = ctx.ID().getText();
        Value value = visit(ctx.res());
        memory.put(id, value);
        return value;
    }
    
    @Override
    public Value visitPrint(ScriptyParser.PrintContext ctx) {
        Value value = visit(ctx.res());
        System.out.println(value.represent());
        return null;
    }

    @Override
    public Value visitIf(ScriptyParser.IfContext ctx) {
        BoolValue cond = (BoolValue) this.visit(ctx.prop());
        if (cond.getValue()){
            return visit(ctx.main);
        }
        else{
            if (ctx.alter != null)
                return visit(ctx.alter);
        }
        return null;
    }

    @Override
    public Value visitWhile(ScriptyParser.WhileContext ctx) {
        BoolValue cond = (BoolValue) this.visit(ctx.prop());

        while(cond.getValue()) {
            visit(ctx.block());
            cond = (BoolValue) this.visit(ctx.prop());
        }
        return null;
    }




    @Override
    public Value visitCompare(ScriptyParser.CompareContext ctx){
        Value left = visit(ctx.left);
        Value right = visit(ctx.right);
        if (ctx.op.getType() == ScriptyParser.GRT)
            return left.greater(right);
        if (ctx.op.getType() == ScriptyParser.LES)
            return left.less(right);
        else
            return left.eql(right);
    }

    @Override
    public Value visitNot(ScriptyParser.NotContext ctx) {
        Value value = visit(ctx.prop());
        return value.neg();
    }

    @Override
    public Value visitAnd(ScriptyParser.AndContext ctx) {
        Value left = visit(ctx.left);
        Value right = visit(ctx.right);
        return left.mul(right);
    }

    @Override
    public Value visitOr(ScriptyParser.OrContext ctx) {
        Value left = visit(ctx.left);
        Value right = visit(ctx.right);
        return left.add(right);
    }

    @Override
    public Value visitTrue(ScriptyParser.TrueContext ctx){
        return new BoolValue(true);
    }

    @Override
    public Value visitFalse(ScriptyParser.FalseContext ctx){
        return new BoolValue(false);
    }

    @Override
    public Value visitPropId(ScriptyParser.PropIdContext ctx) {
        String id = ctx.ID().getText();
        if ( memory.containsKey(id) ) return memory.get(id);
        throw new VariableIsNotDeclaredException(id);
    }

    @Override
    public Value visitPropParens(ScriptyParser.PropParensContext ctx) {
        return visit(ctx.prop());
    }



    @Override
    public Value visitUnaryMinus(ScriptyParser.UnaryMinusContext ctx){
        Value value = visit(ctx.expr());
        return value.neg();
    }

    @Override
    public Value visitMulDiv(ScriptyParser.MulDivContext ctx) {
        Value left = visit(ctx.left);
        Value right = visit(ctx.right);
        switch(ctx.op.getType()){
            case ScriptyParser.DIV:
                return left.div(right);
            case ScriptyParser.IDIV:
                return left.iDiv(right);
            case ScriptyParser.MOD:
                return left.mod(right);
            default:
                return left.mul(right);
        }
    }

    @Override
    public Value visitAddSub(ScriptyParser.AddSubContext ctx) {
        Value left = visit(ctx.left);
        Value right = visit(ctx.right);
        if ( ctx.op.getType() == ScriptyParser.ADD ) return left.add(right);
        return left.sub(right);
    }

    @Override
    public Value visitInt(ScriptyParser.IntContext ctx) {
        return new IntValue(Integer.valueOf(ctx.INT().getText()));
    }

    @Override
    public Value visitFloat(ScriptyParser.FloatContext ctx) {
        return new FloatValue(Float.valueOf(ctx.FLOAT().getText()));
    }

    @Override
    public Value visitString(ScriptyParser.StringContext ctx) {
        String base = ctx.STRING().getText();
        String withoutQuotes = base.substring(1, base.length() - 1);
        String withEscapedChars = withoutQuotes
                .replace("\\\"", "\"")
                .replace("\\\n", "\n")
                ;
        return new StringValue(withEscapedChars);
    }

    @Override
    public Value visitId(ScriptyParser.IdContext ctx) {
        String id = ctx.ID().getText();
        if ( memory.containsKey(id) ) return memory.get(id);
        throw new VariableIsNotDeclaredException(id);
    }

    @Override
    public Value visitParens(ScriptyParser.ParensContext ctx) {
        return visit(ctx.expr());
    }





}