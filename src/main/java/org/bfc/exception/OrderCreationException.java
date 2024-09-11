package org.bfc.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class OrderCreationException extends RuntimeException {
    public OrderCreationException(String message) {
        super(message);
    }
    public OrderCreationException(String message, Throwable cause) {
        super(message, cause);
    }
}
