package br.com.rhianlopes.mycows.controller.register;

import br.com.rhianlopes.mycows.controller.register.request.RegisterUserRequestDto;
import br.com.rhianlopes.mycows.service.user.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author rhian.costa
 */
@RestController
@Api(tags = "Register")
@RequiredArgsConstructor
@RequestMapping("/public/register")
public class PublicRegisterController {

    private final UserService userService;

    @PostMapping("/user")
    @ApiOperation(value = "Register a User on MyCows")
    public HttpStatus registerUser(@RequestBody @Valid RegisterUserRequestDto registerUserRequestDto) {
        userService.registerUser(registerUserRequestDto);
        return HttpStatus.CREATED;
    }
}
