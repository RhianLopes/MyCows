package br.com.rhianlopes.mycows.service.user;

import br.com.rhianlopes.mycows.controller.register.request.RegisterUserRequestDto;

public interface UserService {

    Object registerUser(RegisterUserRequestDto registerUserRequestDto);
}
