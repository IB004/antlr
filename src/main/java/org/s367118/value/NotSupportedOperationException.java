package org.s367118.value;

import org.s367118.value.Value;

public class NotSupportedOperationException extends RuntimeException{
    public NotSupportedOperationException(String operation, Value left, Value right){
        super(String.format("%s '%s' %s is not supported.",
                left.getClass().getSimpleName(),
                operation,
                right.getClass().getSimpleName())
        );
    }

    public NotSupportedOperationException(String operation, Value value){
        super(String.format("'%s' %s is not supported.",
                operation,
                value.getClass().getSimpleName())
        );
    }
}
