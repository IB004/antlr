package org.s367118;

import org.s367118.antlr.LanguageParser;
import org.s367118.antlr.LanguageBaseVisitor;
import org.s367118.value.*;

import java.util.HashMap;
import java.util.Map;

public class EvalVisitor extends LanguageBaseVisitor<Value> {
    Map<String, Value> memory = new HashMap<>();

    @Override
    public Value visitAssign(LanguageParser.AssignContext ctx) {
        String id = ctx.ID().getText();  // id is left-hand side of '='
        Value value = visit(ctx.res());   // compute value of expression on right
        memory.put(id, value);           // store it in our memory
        return value;
    }

    @Override
    public Value visitPrint(LanguageParser.PrintContext ctx) {
        Value value = visit(ctx.res()); // evaluate the expr child
        System.out.println(value.represent());         // print the result
        return null;
    }


    @Override
    public Value visitTrue(LanguageParser.TrueContext ctx){
        return new BoolValue(true);
    }

    @Override
    public Value visitFalse(LanguageParser.FalseContext ctx){
        return new BoolValue(false);
    }

    @Override
    public Value visitCompare(LanguageParser.CompareContext ctx){
        Value left = visit(ctx.expr(0));  // get value of left subexpression
        Value right = visit(ctx.expr(1)); // get value of right subexpression
        if (ctx.op.getType() == LanguageParser.GRT)
            return left.greater(right);
        if (ctx.op.getType() == LanguageParser.LES)
            return left.less(right);
        else
            return left.eql(right);
    }

    @Override
    public Value visitAnd(LanguageParser.AndContext ctx) {
        Value left = visit(ctx.prop(0));  // get value of left subexpression
        Value right = visit(ctx.prop(1)); // get value of right subexpression
        return left.mul(right);
    }

    @Override
    public Value visitOr(LanguageParser.OrContext ctx) {
        Value left = visit(ctx.prop(0));  // get value of left subexpression
        Value right = visit(ctx.prop(1)); // get value of right subexpression
        return left.add(right);
    }

    @Override
    public Value visitNot(LanguageParser.NotContext ctx) {
        Value value = visit(ctx.prop());
        return value.neg();
    }

    @Override
    public Value visitPropParens(LanguageParser.PropParensContext ctx) {
        return visit(ctx.prop());
    }

    @Override
    public Value visitPropId(LanguageParser.PropIdContext ctx) {
        String id = ctx.ID().getText();
        if ( memory.containsKey(id) ) return memory.get(id);
        throw new VariableIsNotDeclaredException(id);
    }

    @Override
    public Value visitInt(LanguageParser.IntContext ctx) {
        return new IntValue(Integer.valueOf(ctx.INT().getText()));
    }

    @Override
    public Value visitFloat(LanguageParser.FloatContext ctx) {
        return new FloatValue(Float.valueOf(ctx.FLOAT().getText()));
    }

    @Override
    public Value visitString(LanguageParser.StringContext ctx) {
        String base = ctx.STRING().getText();
        String withoutQuotes = base.substring(1, base.length() - 1);
        String withEscapedChars = withoutQuotes
                .replace("\\\"", "\"")
                .replace("\\\n", "\n")
                ;
        return new StringValue(withEscapedChars);
    }

    @Override
    public Value visitId(LanguageParser.IdContext ctx) {
        String id = ctx.ID().getText();
        if ( memory.containsKey(id) ) return memory.get(id);
        throw new VariableIsNotDeclaredException(id);
    }

    @Override
    public Value visitMulDiv(LanguageParser.MulDivContext ctx) {
        Value left = visit(ctx.expr(0));  // get value of left subexpression
        Value right = visit(ctx.expr(1)); // get value of right subexpression
        if ( ctx.op.getType() == LanguageParser.MUL ) return left.mul(right);
        return left.div(right); // must be DIV
    }

    @Override
    public Value visitAddSub(LanguageParser.AddSubContext ctx) {
        Value left = visit(ctx.expr(0));  // get value of left subexpression
        Value right = visit(ctx.expr(1)); // get value of right subexpression
        if ( ctx.op.getType() == LanguageParser.ADD ) return left.add(right);
        return left.sub(right); // must be SUB
    }

    @Override
    public Value visitUnaryMinus(LanguageParser.UnaryMinusContext ctx){
        Value value = visit(ctx.expr());
        return value.neg();
    }

    @Override
    public Value visitParens(LanguageParser.ParensContext ctx) {
        return visit(ctx.expr()); // return child expr's value
    }


    @Override
    public Value visitWhile(LanguageParser.WhileContext ctx) {
        BoolValue cond = (BoolValue) this.visit(ctx.prop());

        while(cond.getValue()) {
            visit(ctx.block());
            cond = (BoolValue) this.visit(ctx.prop());
        }
        return null;
    }

    @Override
    public Value visitIf(LanguageParser.IfContext ctx) {
        BoolValue cond = (BoolValue) this.visit(ctx.prop());
        if (cond.getValue()){
            return visit(ctx.body);
        }
        else{
            if (ctx.alter != null)
                return visit(ctx.alter);
        }
        return null;
    }
}