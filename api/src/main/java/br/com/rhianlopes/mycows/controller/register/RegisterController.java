package br.com.rhianlopes.mycows.controller.register;

import br.com.rhianlopes.mycows.controller.register.request.RegisterUserRequestDto;
import br.com.rhianlopes.mycows.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/register")
public class RegisterController {

    private final UserService userService;

    @PostMapping("/user")
    public Object registerUser(@RequestBody @Valid RegisterUserRequestDto registerUserRequestDto) {
        return userService.registerUser(registerUserRequestDto);
    }
}
