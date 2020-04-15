package br.com.rhianlopes.mycows.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.FORBIDDEN)
public abstract class ForbiddenException extends RuntimeException {

    public ForbiddenException(String message) {
        super(message);
    }
}
