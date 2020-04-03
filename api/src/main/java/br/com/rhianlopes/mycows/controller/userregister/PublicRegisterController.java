package br.com.rhianlopes.mycows.controller.userregister;

import br.com.rhianlopes.mycows.controller.userregister.request.RegisterUserRequestDto;
import br.com.rhianlopes.mycows.service.user.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author rhian.costa
 */
@RestController
@Api(tags = "Public Register")
@RequiredArgsConstructor
@RequestMapping("/public/register")
public class PublicRegisterController {

    private final UserService userService;

    @PostMapping("/user")
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Register a User on MyCows")
    public void registerUser(@RequestBody @Valid RegisterUserRequestDto registerUserRequestDto) {
        userService.registerUser(registerUserRequestDto);
    }
}
