package org.bfc.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class AssetServiceException extends RuntimeException {
    public AssetServiceException(String message) {
        super(message);
    }
    public AssetServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}
