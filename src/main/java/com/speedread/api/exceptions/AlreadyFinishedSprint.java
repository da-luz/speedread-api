package com.speedread.api.exceptions;

public class AlreadyFinishedSprint extends RuntimeException {
    private static final Long serialVersionUID = 1L;

    public AlreadyFinishedSprint(String message) {
        super(message);
    }
}
