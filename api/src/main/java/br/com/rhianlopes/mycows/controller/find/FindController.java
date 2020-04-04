package br.com.rhianlopes.mycows.controller.find;

import br.com.rhianlopes.mycows.domain.User;
import br.com.rhianlopes.mycows.domain.security.UserPrincipal;
import br.com.rhianlopes.mycows.service.user.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Email;

/**
 * @author rhian.costa
 */
@RestController
@Api(tags = { "Find One", "Find All" })
@RequiredArgsConstructor
@RequestMapping("/find")
public class FindController {

    private final UserService userService;

    @GetMapping("/logged-user")
    @ApiOperation(value = "Find Logged User", tags = "Find One")
    public User findOneUser(@AuthenticationPrincipal UserPrincipal userPrincipal) {
        return userService.findById(userPrincipal);
    }

    @GetMapping("/user")
    @ApiOperation(value = "Find User By Email", tags = "Find One")
    public User findByEmail(@RequestParam(name = "email") @Email String email) {
        return userService.findByEmail(email);
    }
}
