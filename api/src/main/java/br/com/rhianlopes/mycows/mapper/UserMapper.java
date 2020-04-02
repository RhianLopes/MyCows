package br.com.rhianlopes.mycows.mapper;

import br.com.rhianlopes.mycows.controller.register.request.RegisterUserRequestDto;
import br.com.rhianlopes.mycows.domain.User;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

/**
 * @author rhian.costa
 */
@Component
public class UserMapper {

    public User mapper(RegisterUserRequestDto registerUserRequestDto, String password) {
        return new User()
                .setEmail(registerUserRequestDto.getEmail())
                .setName(registerUserRequestDto.getName())
                .setPhone(registerUserRequestDto.getPhone())
                .setCreatedAt(LocalDate.now())
                .setUpdatedAt(LocalDate.now())
                .setPassword(password);
    }
}
