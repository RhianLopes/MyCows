package br.com.rhianlopes.mycows.service.user;

import br.com.rhianlopes.mycows.controller.register.request.RegisterUserRequestDto;

/**
 * @author rhian.costa
 */
public interface UserService {

    void registerUser(RegisterUserRequestDto registerUserRequestDto);
}