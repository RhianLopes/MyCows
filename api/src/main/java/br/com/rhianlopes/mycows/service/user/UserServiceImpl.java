package br.com.rhianlopes.mycows.service.user;

import br.com.rhianlopes.mycows.controller.register.request.RegisterUserRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    @Override
    public Object registerUser(RegisterUserRequestDto registerUserRequestDto) {
        return null;
    }
}
