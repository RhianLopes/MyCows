package br.com.rhianlopes.mycows.controller.edit;

import br.com.rhianlopes.mycows.controller.edit.request.EditUserRequestDto;
import br.com.rhianlopes.mycows.domain.security.UserPrincipal;
import br.com.rhianlopes.mycows.service.user.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author rhian.costa
 */
@RestController
@Api(tags = "Edit")
@RequiredArgsConstructor
@RequestMapping("/edit")
public class EditController {

    private final UserService userService;

    @PutMapping("/user")
    @ApiOperation(value = "Edit User info")
    public Object editUser(@AuthenticationPrincipal UserPrincipal userPrincipal, @RequestBody @Valid EditUserRequestDto editUserRequestDto) {
        return userService.editUser(userPrincipal, editUserRequestDto);
    }
}
