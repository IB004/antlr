package org.s367118;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.s367118.antlr.LabeledExprLexer;
import org.s367118.antlr.LabeledExprParser;
import org.s367118.value.IntValue;
import org.s367118.value.StringValue;
import org.s367118.value.Value;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Main {
    public static void main(String[] args) throws IOException {

        Value a = new StringValue("mew");
        Value b = new IntValue(2);
        System.out.println((a.add(b)).represent());


        String inputFile = null;
        if ( args.length>0 ) inputFile = args[0];
        InputStream is = System.in;
        if ( inputFile!=null ) is = new FileInputStream(inputFile);
        LabeledExprLexer lexer = new LabeledExprLexer(CharStreams.fromStream(is));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        LabeledExprParser parser = new LabeledExprParser(tokens);
        ParseTree tree = parser.prog(); // parse

        EvalVisitor eval = new EvalVisitor();
        eval.visit(tree);
    }
}