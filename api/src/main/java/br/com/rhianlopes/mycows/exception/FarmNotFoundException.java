package br.com.rhianlopes.mycows.exception;

public class FarmNotFoundException extends BusinessRuleException {

    public FarmNotFoundException(String rule) {
        super(rule);
    }
}
