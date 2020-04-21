package br.com.rhianlopes.mycows.controller.find;

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
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import javax.validation.constraints.Email;
import java.util.List;

/**
 * @author rhian.costa
 */
@RestController
@Api(tags = { "Find One" })
@RequiredArgsConstructor
@RequestMapping("/find")
public class FindController {

    private final UserService userService;

    private final FarmService farmService;

    private final CowService cowService;

    @RolesAllowed({ "ROLE_USER" })
    @GetMapping("/logged-user")
    @ApiOperation(value = "Find Logged User")
    public User findLoggedUser(@AuthenticationPrincipal UserPrincipal userPrincipal) {
        return userService.findById(userPrincipal.getId());
    }

    @RolesAllowed({ "ROLE_USER" })
    @GetMapping("/user")
    @ApiOperation(value = "Find User By Email")
    public User findUserByEmail(@RequestParam(name = "email") @Email String email) {
        return userService.findByEmail(email);
    }

    @GetMapping("/farm/{id}")
    @ApiOperation(value = "Find Farm By Id")
    public Farm findFarmById(@AuthenticationPrincipal UserPrincipal userPrincipal, @PathVariable("id") Long id) {
        return farmService.findByIdAndUserId(userPrincipal.getId(), id);
    }

    @GetMapping("/farm")
    @ApiOperation(value = "Find All Farms By Logged User")
    public List<Farm> findAllFarmsByLoggedUser(@AuthenticationPrincipal UserPrincipal userPrincipal) {
        return farmService.findAllByUserId(userPrincipal.getId());
    }

    @GetMapping("/cow/{id}")
    @ApiOperation(value = "Find Cow By Id")
    public Cow findCowById(@AuthenticationPrincipal UserPrincipal userPrincipal, @PathVariable("id") Long id) {
        return cowService.findCowByIdAndUserId(id, userPrincipal.getId());
    }

    @GetMapping("/cow/active/{farmId}")
    @ApiOperation(value = "Find All Cows By Farm Id And Is Active")
    public List<Cow> findAllCowsByFarmIdAndIsActive(@AuthenticationPrincipal UserPrincipal userPrincipal, @PathVariable("farmId") Long farmId) {
        return cowService.findAllByFarmIdAndUserIdAndIsActive(farmId, userPrincipal.getId(), true);
    }

    @GetMapping("/cow/{farmId}")
    @ApiOperation(value = "Find All Cows By Farm Id And Is Not Active")
    public List<Cow> findAllCowsByFarmIdAndIsNotActive(@AuthenticationPrincipal UserPrincipal userPrincipal, @PathVariable("farmId") Long farmId) {
        return cowService.findAllByFarmIdAndUserIdAndIsActive(farmId, userPrincipal.getId(), false);
    }
}
