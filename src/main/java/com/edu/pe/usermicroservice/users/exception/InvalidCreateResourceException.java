package com.edu.pe.usermicroservice.users.exception;

public class InvalidCreateResourceException extends RuntimeException {
    public InvalidCreateResourceException() {

    }
    public InvalidCreateResourceException(String message) {
        super(message);
    }
}
