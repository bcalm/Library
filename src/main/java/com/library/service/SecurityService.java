package com.library.service;

import org.springframework.stereotype.Service;

@Service
public class SecurityService {

    public String welcomeUser() {
        return "Hello user";
    }
}