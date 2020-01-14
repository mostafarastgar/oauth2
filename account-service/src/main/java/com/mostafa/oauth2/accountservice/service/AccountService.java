package com.mostafa.accountservice.service;

import com.mostafa.accountservice.dto.UserDto;
import com.mostafa.accountservice.dto.UserRegistrationDto;

public interface AccountService {

    /**
     * Invokes Auth Service user creation
     *
     * @param user
     * @return created account
     */
    UserDto create(UserRegistrationDto user);
}
