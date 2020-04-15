package br.com.rhianlopes.mycows.exception;

/**
 * @author rhian.costa
 */
public class UserAlreadyExistsException extends BusinessRuleException {

    public UserAlreadyExistsException(String rule) {
        super(rule);
    }
}
