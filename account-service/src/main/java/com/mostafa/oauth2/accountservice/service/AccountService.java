package com.mostafa.oauth2.accountservice.service;

import com.mostafa.oauth2.accountservice.dto.UserDto;
import com.mostafa.oauth2.accountservice.dto.UserRegistrationDto;

public interface AccountService {

    /**
     * Invokes Auth Service user creation
     *
     * @param user
     * @return created account
     */
    UserDto create(UserRegistrationDto user);
}
