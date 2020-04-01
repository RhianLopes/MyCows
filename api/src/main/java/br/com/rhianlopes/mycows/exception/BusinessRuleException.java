package br.com.rhianlopes.mycows.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public abstract class BusinessRuleException extends RuntimeException {

    public BusinessRuleException(String rule){
        super(rule);
    }
}
