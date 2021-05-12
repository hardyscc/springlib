package com.sysforce.springlib.exception;

public class ErrorMessage {
    private final Integer statusCode;
    private final String[] message;
    private final String error;

    public ErrorMessage(Integer statusCode, String[] message, String error) {
        this.statusCode = statusCode;
        this.message = message;
        this.error = error;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public String[] getMessage() {
        return message;
    }

    public String getError() {
        return error;
    }
}