package br.com.rhianlopes.mycows.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author rhian.costa
 */
@RestController
public class MyCowsApiController {

    @GetMapping("/verify")
    public HttpStatus verify() {
        return HttpStatus.OK;
    }
}
