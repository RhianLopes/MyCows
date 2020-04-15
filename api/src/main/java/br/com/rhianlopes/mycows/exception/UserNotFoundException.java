package br.com.rhianlopes.mycows.exception;

/**
 * @author rhian.costa
 */
public class UserNotFoundException extends BusinessRuleException {

    public UserNotFoundException(String rule) {
        super(rule);
    }
}
