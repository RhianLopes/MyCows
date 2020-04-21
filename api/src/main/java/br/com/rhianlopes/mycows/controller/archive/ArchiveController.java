package br.com.rhianlopes.mycows.controller.archive;

import br.com.rhianlopes.mycows.domain.Cow;
import br.com.rhianlopes.mycows.domain.security.UserPrincipal;
import br.com.rhianlopes.mycows.service.cow.CowService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author rhian.costa
 */
@RestController
@Api(tags = { "Archive" })
@RequiredArgsConstructor
@RequestMapping("/archive")
public class ArchiveController {

    private final CowService cowService;

    @GetMapping("/cow/{id}")
    @ApiOperation(value = "Archive Cow By Cow Id")
    public Cow findFarmById(@AuthenticationPrincipal UserPrincipal userPrincipal, @PathVariable("id") Long cowId) {
        return cowService.archiveCowByIdAndUserId(cowId, userPrincipal.getId());
    }
}
