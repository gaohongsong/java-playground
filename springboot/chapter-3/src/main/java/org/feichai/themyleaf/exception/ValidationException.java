package org.feichai.themyleaf.exception;

import java.io.Serial;

public class ValidationException extends AppException {
    @Serial
    private static final long serialVersionUID = 1L;

    public ValidationException(String message) {
        super(message);
    }
}
