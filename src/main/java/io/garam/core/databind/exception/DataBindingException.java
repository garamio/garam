package io.garam.core.databind.exception;

public class DataBindingException extends RuntimeException {

    public DataBindingException(String message) {
        super(message);
    }

    public DataBindingException(String message, Throwable cause) {
        super(message, cause);
    }
}
