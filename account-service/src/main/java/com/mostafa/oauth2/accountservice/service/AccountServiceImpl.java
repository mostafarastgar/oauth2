package com.mostafa.oauth2.accountservice.service;

import com.mostafa.oauth2.accountservice.client.AuthServiceFeignClient;
import com.mostafa.oauth2.accountservice.dto.UserDto;
import com.mostafa.oauth2.accountservice.dto.UserRegistrationDto;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

    private final AuthServiceFeignClient authServiceFeignClient;

    public AccountServiceImpl(AuthServiceFeignClient authServiceFeignClient) {
        this.authServiceFeignClient = authServiceFeignClient;
    }

    @Override
    public UserDto create(UserRegistrationDto user) {
        return authServiceFeignClient.createUser(user);
    }
}
