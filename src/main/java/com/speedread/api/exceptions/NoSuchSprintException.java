package com.speedread.api.exceptions;


public class NoSuchSprintException extends RuntimeException {
    private static final Long serialVersionUID = 1L;

    public NoSuchSprintException(String message) {
        super(message);
    }
}
