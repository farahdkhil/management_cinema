package com.example.gestion_cinema.exceptions;

import ch.qos.logback.core.spi.ErrorCodes;

import java.util.List;

public class InvalidEntityException extends RuntimeException{

    private ErrorCodes errorCode;
    private List<String> errors;
    public InvalidEntityException(String message, ErrorCodes errorCode, List<String> errors) {
        super(message);
        this.errorCode = errorCode;
        this.errors = errors;
    }

    public InvalidEntityException(String message, List<String> errors) {
        super(message);
        this.errors = errors;
    }

    public InvalidEntityException(String message, ErrorCodes errorCode) {
        super(message);
        this.errorCode = errorCode;
    }
    public InvalidEntityException(String message) {
        super(message);
    }

    public ErrorCodes getErrorCode() {
        return errorCode;
    }

    public List<String> getErrors() {
        return errors;
    }

}
