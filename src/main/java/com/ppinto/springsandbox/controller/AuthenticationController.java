package com.ppinto.springsandbox.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class AuthenticationController {

    @GetMapping("me")
    public Principal getSelf(Principal principal) {
        return principal;
    }
}
