package com.juniorbarros.model;

public class OverflowException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public OverflowException(String message) {
        super(message);
    }
}