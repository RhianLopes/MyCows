package br.com.rhianlopes.mycows.service.user;

import br.com.rhianlopes.mycows.controller.edit.request.EditUserRequestDto;
import br.com.rhianlopes.mycows.controller.userregister.request.RegisterUserRequestDto;
import br.com.rhianlopes.mycows.domain.User;
import br.com.rhianlopes.mycows.domain.security.UserPrincipal;

/**
 * @author rhian.costa
 */
public interface UserService {

    void registerUser(RegisterUserRequestDto registerUserRequestDto);

    User editUser(UserPrincipal userPrincipal, EditUserRequestDto editUserRequestDto);

    User findById(UserPrincipal userPrincipal);

    User findByEmail(String email);
}
