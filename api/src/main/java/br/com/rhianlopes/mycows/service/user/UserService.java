package br.com.rhianlopes.mycows.service.user;

import br.com.rhianlopes.mycows.controller.edit.request.EditUserRequestDto;
import br.com.rhianlopes.mycows.controller.userregister.request.RegisterUserRequestDto;
import br.com.rhianlopes.mycows.domain.security.UserPrincipal;

/**
 * @author rhian.costa
 */
public interface UserService {

    void registerUser(RegisterUserRequestDto registerUserRequestDto);

    Object editUser(UserPrincipal userPrincipal, EditUserRequestDto editUserRequestDto);

    Object findById(UserPrincipal userPrincipal);
}
