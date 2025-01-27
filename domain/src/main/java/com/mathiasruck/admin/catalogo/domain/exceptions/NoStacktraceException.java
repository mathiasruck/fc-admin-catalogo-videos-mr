package com.mathiasruck.admin.catalogo.domain.exceptions;

public class NoStacktraceException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public NoStacktraceException(String message) {
        this(message, null);
    }

    public NoStacktraceException(String message, Throwable cause) {
        super(message, cause, true, false);
    }
}
