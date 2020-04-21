package br.com.rhianlopes.mycows.service.user;

import br.com.rhianlopes.mycows.controller.edit.request.EditUserRequestDto;
import br.com.rhianlopes.mycows.controller.userregister.request.RegisterUserRequestDto;
import br.com.rhianlopes.mycows.domain.User;

/**
 * @author rhian.costa
 */
public interface UserService {

    void registerUser(RegisterUserRequestDto registerUserRequestDto);

    User editUser(Long id, EditUserRequestDto editUserRequestDto);

    User findById(Long id);

    User findByEmail(String email);

}
