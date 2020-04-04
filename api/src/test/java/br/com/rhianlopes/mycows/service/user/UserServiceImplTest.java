package br.com.rhianlopes.mycows.service.user;

import br.com.rhianlopes.mycows.controller.edit.request.EditUserRequestDto;
import br.com.rhianlopes.mycows.controller.userregister.request.RegisterUserRequestDto;
import br.com.rhianlopes.mycows.domain.User;
import br.com.rhianlopes.mycows.domain.security.UserPrincipal;
import br.com.rhianlopes.mycows.exception.UserAlreadyExistsException;
import br.com.rhianlopes.mycows.exception.UserNotFoundException;
import br.com.rhianlopes.mycows.mapper.UserMapper;
import br.com.rhianlopes.mycows.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceImplTest {

    @InjectMocks
    private UserServiceImpl userService;

    @Mock
    private PasswordEncoder passwordEncoder;

    @Mock
    private UserRepository userRepository;

    @Mock
    private UserMapper userMapper;

    @Test
    public void registerUser_withSuccess() {

        final RegisterUserRequestDto requestDto = Mockito.mock(RegisterUserRequestDto.class);
        final String encodedPassword = "somePassword";
        final User user = Mockito.mock(User.class);

        given(userRepository.existsByEmail(requestDto.getEmail()))
                .willReturn(false);

        given(passwordEncoder.encode(requestDto.getPassword()))
                .willReturn(encodedPassword);

        given(userMapper.mapperToRegisterNewUser(requestDto, encodedPassword))
                .willReturn(user);

        userService.registerUser(requestDto);
        verify(userRepository).save(user);
    }

    @Test
    public void registerUser_withUserAlreadyExists_withException() {

        final RegisterUserRequestDto requestDto = Mockito.mock(RegisterUserRequestDto.class);
        final String exceptionMessage = "User Already Exists!";
        final boolean value = true;

        given(userRepository.existsByEmail(requestDto.getEmail()))
                .willReturn(value);

        Throwable throwable = assertThrows(UserAlreadyExistsException.class, () -> {
            userService.registerUser(requestDto);
        });
        assertEquals(exceptionMessage, throwable.getMessage());
    }

    @Test
    public void editUser_withSuccess() {

        final Long id = 1L;
        final EditUserRequestDto editUserRequestDto = Mockito.mock(EditUserRequestDto.class);
        final User expectedUser = Mockito.mock(User.class);

        given(userRepository.findById(id))
                .willReturn(Optional.of(expectedUser));

        given(userMapper.mapperToEditUser(expectedUser, editUserRequestDto))
                .willReturn(expectedUser);

        given(userRepository.save(expectedUser))
                .willReturn(expectedUser);

        final User resultUser = userService.editUser(id, editUserRequestDto);

        assertEquals(expectedUser, resultUser);
    }

    @Test
    public void findById_withSuccess() {

        final Long id = 1L;
        final User expected = Mockito.mock(User.class);

        given(userRepository.findById(id))
                .willReturn(Optional.of(expected));

        final User result = userService.findById(id);

        assertEquals(expected, result);
    }

    @Test
    public void findById_withUserNotFound_withException() {

        final Long id = 1L;
        final String exceptionMessage = "User Not Found!";

        given(userRepository.findById(id))
                .willReturn(Optional.empty());

        Throwable throwable = assertThrows(UserNotFoundException.class, () -> {
            userService.findById(id);
        });
        assertEquals(exceptionMessage, throwable.getMessage());
    }

    @Test
    public void findByEmail_withSuccess() {

        final String email = "someEmail";
        final User expected = Mockito.mock(User.class);

        given(userRepository.findByEmail(email))
                .willReturn(Optional.of(expected));

        final User result = userService.findByEmail(email);

        assertEquals(expected, result);
    }

    @Test
    public void findByEmail_withUserNotFound_withException() {

        final String email = "someEmail";
        final String exceptionMessage = "User Not Found!";

        given(userRepository.findByEmail(email))
                .willReturn(Optional.empty());

        Throwable throwable = assertThrows(UserNotFoundException.class, () -> {
           userService.findByEmail(email);
        });
        assertEquals(exceptionMessage, throwable.getMessage());
    }
}