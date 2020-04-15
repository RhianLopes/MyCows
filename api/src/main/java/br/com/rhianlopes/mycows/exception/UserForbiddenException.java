package br.com.rhianlopes.mycows.exception;

public class UserForbiddenException extends ForbiddenException {

    public UserForbiddenException(String message) {
        super(message);
    }
}
