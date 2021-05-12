package com.sysforce.springlib.exception.impl;

public class NotFoundException extends RuntimeException {

    private static final long serialVersionUID = -317384287570271849L;

    public NotFoundException(String message) {
        super(message);
    }
}
