package br.com.rhianlopes.mycows.mapper;

import br.com.rhianlopes.mycows.controller.edit.request.EditUserRequestDto;
import br.com.rhianlopes.mycows.controller.userregister.request.RegisterUserRequestDto;
import br.com.rhianlopes.mycows.domain.User;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author rhian.costa
 */
@Component
public class UserMapper {

    public User mapperToRegisterNewUser(RegisterUserRequestDto registerUserRequestDto, String password) {
        return new User()
                .setEmail(registerUserRequestDto.getEmail())
                .setName(registerUserRequestDto.getName())
                .setPhone(registerUserRequestDto.getPhone())
                .setCreatedAt(LocalDate.now())
                .setUpdatedAt(LocalDate.now())
                .setPassword(password);
    }

    public User mapperToEditUser(User user, EditUserRequestDto requestDto) {
        return user
                .setEmail(requestDto.getEmail())
                .setPhone(requestDto.getPhone())
                .setName(requestDto.getName())
                .setUpdatedAt(LocalDate.now());
    }
}
