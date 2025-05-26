package org.s367118;

public class VariableIsNotDeclaredException extends RuntimeException{
    public VariableIsNotDeclaredException(String name){
        super(String.format("Variable '%s' was not declared.", name));
    }
}
