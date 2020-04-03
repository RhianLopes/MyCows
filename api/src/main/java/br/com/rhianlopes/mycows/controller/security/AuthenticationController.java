package br.com.rhianlopes.mycows.controller.security;

import br.com.rhianlopes.mycows.controller.security.request.LoginRequestDto;
import br.com.rhianlopes.mycows.controller.security.response.LoginResponseDto;
import br.com.rhianlopes.mycows.service.security.AuthenticationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author rhian.costa
 */
@RestController
@Api(tags = "Auth")
@RequiredArgsConstructor
@RequestMapping("/public/auth")
public class AuthenticationController {

    @Autowired
    private final AuthenticationService service;

    @PostMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Login a User with E-mail and Password")
    public LoginResponseDto login(@RequestBody @Valid LoginRequestDto request) {
        return new LoginResponseDto(service.authenticate(request.getEmail(), request.getPassword()));
    }
}
