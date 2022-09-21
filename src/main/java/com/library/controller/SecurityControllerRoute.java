package com.library.controller;

import org.springframework.web.bind.annotation.GetMapping;

public interface SecurityControllerRoute {

    @GetMapping(value = "/welcome")
    String welcomeUser();
}
