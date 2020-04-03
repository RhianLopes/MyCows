package br.com.rhianlopes.mycows.service.user;

import br.com.rhianlopes.mycows.controller.userregister.request.RegisterUserRequestDto;
import br.com.rhianlopes.mycows.domain.User;
import br.com.rhianlopes.mycows.exception.UserAlreadyExistsException;
import br.com.rhianlopes.mycows.mapper.UserMapper;
import br.com.rhianlopes.mycows.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;

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

        given(userMapper.mapper(requestDto, encodedPassword))
                .willReturn(user);

        userService.registerUser(requestDto);
        verify(userRepository).save(user);
    }

//    @Test TODO: Rhian Lopes da Costa - 01/04/2020 - find a solution to mock throw
    public void registerUser_withUserAlreadyExists_withException() {

        final RegisterUserRequestDto requestDto = Mockito.mock(RegisterUserRequestDto.class);
        final boolean value = true;

        given(userRepository.existsByEmail(requestDto.getEmail()))
                .willReturn(value);

        userService.registerUser(requestDto);
        assertThrows(UserAlreadyExistsException.class, () -> {
            if (value) {
                throw new UserAlreadyExistsException("User Already Exists!");
            }
        });
    }
}