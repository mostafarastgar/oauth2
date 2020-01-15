package com.mostafa.oauth2.accountservice.controller;

import com.mostafa.oauth2.accountservice.dto.UserDto;
import com.mostafa.oauth2.accountservice.dto.UserRegistrationDto;
import com.mostafa.oauth2.accountservice.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.oauth2.client.OAuth2RestOperations;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping
    public UserDto createNewAccount(@RequestBody UserRegistrationDto user) {
        return accountService.create(user);
    }

    @Autowired
    private OAuth2RestOperations restTemplate;

    @Autowired
    private Environment environment;

    @GetMapping("/readProtectedData")
    @PreAuthorize("hasRole('ROLE_USER')")
    public String test(){
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(Objects.requireNonNull(environment.getProperty("security.oauth2.resource.user-info-uri")), String.class);
        return "you are :" + Objects.requireNonNull(responseEntity.getBody());
    }
}
