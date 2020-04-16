package br.com.rhianlopes.mycows.controller.edit;

import br.com.rhianlopes.mycows.controller.edit.request.EditCowRequestDto;
import br.com.rhianlopes.mycows.controller.edit.request.EditFarmRequestDto;
import br.com.rhianlopes.mycows.controller.edit.request.EditUserRequestDto;
import br.com.rhianlopes.mycows.domain.Cow;
import br.com.rhianlopes.mycows.domain.Farm;
import br.com.rhianlopes.mycows.domain.User;
import br.com.rhianlopes.mycows.domain.security.UserPrincipal;
import br.com.rhianlopes.mycows.service.cow.CowService;
import br.com.rhianlopes.mycows.service.farm.FarmService;
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

    private final FarmService farmService;

    private final CowService cowService;

    @PutMapping("/user")
    @ApiOperation(value = "Edit User infos")
    public User editUser(@RequestBody @Valid EditUserRequestDto editUserRequestDto, @AuthenticationPrincipal UserPrincipal userPrincipal) {
        return userService.editUser(userPrincipal.getId(), editUserRequestDto);
    }

    @PutMapping("/farm")
    @ApiOperation(value = "Edit Farm infos")
    public Farm editFarm(@RequestBody @Valid EditFarmRequestDto editUserRequestDto) {
        return farmService.editFarm(editUserRequestDto);
    }

    @PutMapping("/cow")
    @ApiOperation(value = "Edit Cow infos")
    public Cow editCow(@RequestBody @Valid EditCowRequestDto editCowRequestDto, @AuthenticationPrincipal UserPrincipal userPrincipal) {
        return cowService.editFarm(editCowRequestDto, userPrincipal.getId());
    }
}
