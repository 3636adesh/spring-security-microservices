package com.malunjkar.callme.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/call-me")
public class CallMeController {

    @GetMapping("/ping")
    @PreAuthorize("hasAuthority('SCOPE_TEST')")
    public String ping() {
        var authentication= SecurityContextHolder.getContext().getAuthentication();
        return "Scopes: " + authentication.getAuthorities();
    }
}
