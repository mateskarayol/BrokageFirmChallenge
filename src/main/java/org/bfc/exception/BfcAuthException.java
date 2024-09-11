package org.bfc.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BfcAuthException extends RuntimeException {
    public BfcAuthException(String message) {
        super(message);
    }
    public BfcAuthException(String message, Throwable cause) {
        super(message, cause);
    }
}
