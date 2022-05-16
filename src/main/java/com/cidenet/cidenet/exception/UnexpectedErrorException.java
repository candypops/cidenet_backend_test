package com.cidenet.cidenet.exception;

public class UnexpectedErrorException extends RuntimeException {
    public UnexpectedErrorException() {
    }

    public UnexpectedErrorException(String message) {
        super(message);
    }
}
