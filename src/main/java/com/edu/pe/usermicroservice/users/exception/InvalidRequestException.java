package com.edu.pe.usermicroservice.users.exception;

public class InvalidRequestException extends RuntimeException {
    public InvalidRequestException() {}
    public InvalidRequestException(String message) { super(message); }
}
