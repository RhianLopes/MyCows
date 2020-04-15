package br.com.rhianlopes.mycows.exception;

/**
 * @author rhian.costa
 */
public class UserForbiddenException extends ForbiddenException {

    public UserForbiddenException(String message) {
        super(message);
    }
}
