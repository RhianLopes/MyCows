package br.com.rhianlopes.mycows.exception;

/**
 * @author rhian.costa
 */
public class FarmNotFoundException extends BusinessRuleException {

    public FarmNotFoundException(String rule) {
        super(rule);
    }
}
