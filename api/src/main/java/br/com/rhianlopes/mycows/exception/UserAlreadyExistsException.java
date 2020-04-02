package br.com.rhianlopes.mycows.exception;

public class UserAlreadyExistsException extends BusinessRuleException {

    public UserAlreadyExistsException(String rule) {
        super(rule);
    }
}
