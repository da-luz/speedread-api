package com.speedread.api.exceptions;


public class CannotChangeBookStateException extends RuntimeException {
    private static final Long serialVersionUID = 1L;

    public CannotChangeBookStateException(String message) {
        super(message);
    }

}
