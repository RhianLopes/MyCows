package br.com.rhianlopes.mycows.controller.register;

import br.com.rhianlopes.mycows.controller.register.request.RegisterCowRequestDto;
import br.com.rhianlopes.mycows.controller.register.request.RegisterFarmRequestDto;
import br.com.rhianlopes.mycows.controller.register.request.RegisterMilkRequestDto;
import br.com.rhianlopes.mycows.controller.userregister.request.RegisterUserRequestDto;
import br.com.rhianlopes.mycows.domain.Cow;
import br.com.rhianlopes.mycows.domain.Farm;
import br.com.rhianlopes.mycows.domain.security.UserPrincipal;
import br.com.rhianlopes.mycows.service.cow.CowService;
import br.com.rhianlopes.mycows.service.farm.FarmService;
import br.com.rhianlopes.mycows.service.milk.MilkService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author rhian.costa
 */
@RestController
@RequiredArgsConstructor
@Api(tags = "Register")
@RequestMapping("/register")
public class RegisterController {

    private final MilkService milkService;

    private final FarmService farmService;

    private final CowService cowService;

    @PostMapping("/farm")
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Register a Farm to Logged User")
    public Farm registerFarm(@AuthenticationPrincipal UserPrincipal userPrincipal, @RequestBody @Valid RegisterFarmRequestDto registerFarmRequestDto) {
        return farmService.registerFarm(userPrincipal.getId(), registerFarmRequestDto);
    }

    @PostMapping("/cow")
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Register a Cow to Logged User")
    public Cow registerCow(@AuthenticationPrincipal UserPrincipal userPrincipal, @RequestBody @Valid RegisterCowRequestDto registerCowRequestDto) {
        return cowService.registerCow(userPrincipal.getId(), registerCowRequestDto);
    }

    @PostMapping("/milk")
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Register a Milk to Cow")
    public Object registerMilk(@AuthenticationPrincipal UserPrincipal userPrincipal, @RequestBody @Valid RegisterMilkRequestDto registerMilkRequestDto) {
        return milkService.registerMilk(userPrincipal.getId(), registerMilkRequestDto);
    }
}
