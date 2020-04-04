package br.com.rhianlopes.mycows.controller.find;

import br.com.rhianlopes.mycows.domain.User;
import br.com.rhianlopes.mycows.domain.security.UserPrincipal;
import br.com.rhianlopes.mycows.service.user.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author rhian.costa
 */
@RestController
@Api(tags = { "Find One", "Find All" })
@RequiredArgsConstructor
@RequestMapping("/find")
public class FindController {

    private final UserService userService;

    @PutMapping("/user")
    @ApiOperation(value = "Find Logged User", tags = "Find One")
    public User findOneUser(@AuthenticationPrincipal UserPrincipal userPrincipal) {
        return userService.findById(userPrincipal);
    }
}
