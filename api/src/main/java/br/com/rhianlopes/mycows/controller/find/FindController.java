package br.com.rhianlopes.mycows.controller.find;

import br.com.rhianlopes.mycows.domain.User;
import br.com.rhianlopes.mycows.domain.security.UserPrincipal;
import br.com.rhianlopes.mycows.service.user.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import javax.validation.constraints.Email;

/**
 * @author rhian.costa
 */
@RestController
@Api(tags = { "Find One" })
@RequiredArgsConstructor
@RequestMapping("/find")
public class FindController {

    private final UserService userService;

    @RolesAllowed({ "ROLE_USER" })
    @GetMapping("/logged-user")
    @ApiOperation(value = "Find Logged User")
    public User findOneUser(@AuthenticationPrincipal UserPrincipal userPrincipal) {
        return userService.findById(userPrincipal);
    }

    @RolesAllowed({ "ROLE_USER" })
    @GetMapping("/user")
    @ApiOperation(value = "Find User By Email")
    public User findByEmail(@RequestParam(name = "email") @Email String email) {
        return userService.findByEmail(email);
    }
}
