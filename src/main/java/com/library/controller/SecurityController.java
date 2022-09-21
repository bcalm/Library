package com.library.controller;

import com.library.service.SecurityService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecurityController implements SecurityControllerRoute {

    private final SecurityService securityService;

    public SecurityController(SecurityService securityService) {
        this.securityService = securityService;
    }

    @Override
    public String welcomeUser() {
        return securityService.welcomeUser();
    }
}
