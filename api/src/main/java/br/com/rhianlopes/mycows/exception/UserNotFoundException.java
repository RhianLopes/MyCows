package br.com.rhianlopes.mycows.exception;

public class UserNotFoundException extends BusinessRuleException {

    public UserNotFoundException(String rule) {
        super(rule);
    }
}
