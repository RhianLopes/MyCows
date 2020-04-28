package br.com.rhianlopes.mycows.exception;

/**
 * @author rhian.costa
 */
public class MilkNotFoundException extends BusinessRuleException {

    public MilkNotFoundException(String rule) {
        super(rule);
    }
}
