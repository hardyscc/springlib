package com.sysforce.springlib.exception.impl;

public class BadRequestException extends RuntimeException {

    private static final long serialVersionUID = 2606368852912184031L;

    public BadRequestException(String message) {
        super(message);
    }
}
