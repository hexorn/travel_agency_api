package com.epam.finaltask.exception;

public class InvalidCredentialsException extends RuntimeException {
    private static final String INVALID_CREDENTIALS_MESSAGE = "Invalid credentials";
    public InvalidCredentialsException() {
        super(INVALID_CREDENTIALS_MESSAGE);
    }
}
