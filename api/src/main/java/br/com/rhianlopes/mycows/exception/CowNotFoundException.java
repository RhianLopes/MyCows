package br.com.rhianlopes.mycows.exception;

public class CowNotFoundException extends BusinessRuleException {

    public CowNotFoundException(String rule) {
        super(rule);
    }
}
