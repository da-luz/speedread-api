package com.speedread.api.exceptions;

public class CannotReadMultipleBooksException extends RuntimeException {
    private static final Long serialVersionUID = 1L;

    public CannotReadMultipleBooksException(String message) {
        super(message);
    }
}
