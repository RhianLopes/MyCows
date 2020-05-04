package br.com.rhianlopes.mycows.controller.find;

import br.com.rhianlopes.mycows.domain.Cow;
import br.com.rhianlopes.mycows.domain.Farm;
import br.com.rhianlopes.mycows.domain.Milk;
import br.com.rhianlopes.mycows.domain.User;
import br.com.rhianlopes.mycows.domain.security.UserPrincipal;
import br.com.rhianlopes.mycows.service.cow.CowService;
import br.com.rhianlopes.mycows.service.farm.FarmService;
import br.com.rhianlopes.mycows.service.milk.MilkService;
import br.com.rhianlopes.mycows.service.user.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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

    private final MilkService milkService;

    private final CowService cowService;

    @GetMapping("/logged-user")
    @ApiOperation(value = "Find Logged User")
    public User findLoggedUser(@AuthenticationPrincipal UserPrincipal userPrincipal) {
        return userService.findById(userPrincipal.getId());
    }

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

    @GetMapping("/cow/{cowId}")
    @ApiOperation(value = "Find Cow By Id")
    public Cow findCowById(@AuthenticationPrincipal UserPrincipal userPrincipal, @PathVariable("cowId") Long cowId) {
        return cowService.findCowByIdAndUserId(cowId, userPrincipal.getId());
    }

    @GetMapping("/cow/active/{farmId}")
    @ApiOperation(value = "Find All Cows By Farm Id And Is Active")
    public List<Cow> findAllCowsByFarmIdAndIsActive(@AuthenticationPrincipal UserPrincipal userPrincipal, @PathVariable("farmId") Long farmId) {
        return cowService.findAllByFarmIdAndUserIdAndIsActive(farmId, userPrincipal.getId(), true);
    }

    @GetMapping("/cow/inactive/{farmId}")
    @ApiOperation(value = "Find All Cows By Farm Id And Is Not Active")
    public List<Cow> findAllCowsByFarmIdAndIsNotActive(@AuthenticationPrincipal UserPrincipal userPrincipal, @PathVariable("farmId") Long farmId) {
        return cowService.findAllByFarmIdAndUserIdAndIsActive(farmId, userPrincipal.getId(), false);
    }

    @GetMapping("/milk/{milkId}")
    @ApiOperation(value = "Find Milk By Id")
    public Milk findMilkById(@AuthenticationPrincipal UserPrincipal userPrincipal, @PathVariable("milkId") Long milkId) {
        return milkService.findByMilkIdAndUserId(milkId, userPrincipal.getId());
    }
}
