package br.com.rhianlopes.mycows.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author rhian.costa
 */
@Api(tags = "MyCowsApi")
@RestController("/public")
public class MyCowsApiController {

    @GetMapping("/verify")
    @ApiOperation(value = "Verify api is up")
    public HttpStatus verify() {
        return HttpStatus.OK;
    }
}
