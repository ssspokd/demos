package com.example.test.exception;

public class MyResourceNotFoundException extends Throwable {

    private static final long serialVersionUID = 1L;

    public MyResourceNotFoundException(String message) {
        super(message);
    }

    public MyResourceNotFoundException(String message, Throwable t) {
        super(message, t);
    }

    public MyResourceNotFoundException() {

    }
}
