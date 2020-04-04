package br.com.rhianlopes.mycows.mapper;

import br.com.rhianlopes.mycows.controller.edit.request.EditUserRequestDto;
import br.com.rhianlopes.mycows.controller.userregister.request.RegisterUserRequestDto;
import br.com.rhianlopes.mycows.domain.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class UserMapperTest {

    @InjectMocks
    private UserMapper userMapper;

    @Test
    public void mapperToRegisterNewUser_withSuccess() {

        final RegisterUserRequestDto registerUserRequestDto = Mockito.mock(RegisterUserRequestDto.class);
        final String password = "somePassword";

        final User expectedUser = new User()
                .setEmail(registerUserRequestDto.getEmail())
                .setName(registerUserRequestDto.getName())
                .setPhone(registerUserRequestDto.getPhone())
                .setCreatedAt(LocalDate.now())
                .setUpdatedAt(LocalDate.now())
                .setPassword(password);

        final User resultUser = userMapper.mapperToRegisterNewUser(registerUserRequestDto, password);

        assertEquals(expectedUser, resultUser);
    }

    @Test
    public void mapperToEditUser_withSuccess() {

        final EditUserRequestDto requestDto = Mockito.mock(EditUserRequestDto.class);
        final User user = new User();

        final User expectedUser = new User()
                .setEmail(requestDto.getEmail())
                .setPhone(requestDto.getPhone())
                .setName(requestDto.getName())
                .setUpdatedAt(LocalDate.now());

        final User resultUser = userMapper.mapperToEditUser(user, requestDto);

        assertEquals(expectedUser, resultUser);
    }
}