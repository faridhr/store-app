package com.indocyber.store.app.utils.exception;

public class OperationFailedException extends RuntimeException {

    public OperationFailedException() {
    }

    public OperationFailedException(String message) {
        super(message);
    }

    public OperationFailedException(String message, Throwable cause) {
        super(message, cause);
    }
}
