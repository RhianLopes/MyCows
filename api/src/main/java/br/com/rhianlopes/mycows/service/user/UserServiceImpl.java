package br.com.rhianlopes.mycows.service.user;

import br.com.rhianlopes.mycows.controller.edit.request.EditUserRequestDto;
import br.com.rhianlopes.mycows.controller.userregister.request.RegisterUserRequestDto;
import br.com.rhianlopes.mycows.domain.User;
import br.com.rhianlopes.mycows.domain.security.UserPrincipal;
import br.com.rhianlopes.mycows.exception.UserAlreadyExistsException;
import br.com.rhianlopes.mycows.mapper.UserMapper;
import br.com.rhianlopes.mycows.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @author rhian.costa
 */
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final PasswordEncoder passwordEncoder;

    private final UserRepository userRepository;

    private final UserMapper userMapper;

    @Override
    public void registerUser(RegisterUserRequestDto requestDto) {

        boolean userAlreadyExists = userRepository.existsByEmail(requestDto.getEmail());

        if (userAlreadyExists) {
            throw new UserAlreadyExistsException("User Already Exists!");
        }

        final String encodedPassword = passwordEncoder.encode(requestDto.getPassword());

        final User user = userMapper.mapper(requestDto, encodedPassword);

        userRepository.save(user);
    }

    @Override
    public Object editUser(UserPrincipal userPrincipal, EditUserRequestDto requestDto) {



        return null;
    }

    @Override
    public Object findById(UserPrincipal userPrincipal) {
        return null;
    }
}
