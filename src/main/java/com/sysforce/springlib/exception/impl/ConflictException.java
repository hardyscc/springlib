package com.sysforce.springlib.exception.impl;

public class ConflictException extends RuntimeException {

    private static final long serialVersionUID = -7160572977773849040L;

    public ConflictException(String message) {
        super(message);
    }
}
