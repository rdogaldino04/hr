package com.rgv04.hr.security.service;

import com.rgv04.hr.exception.EntityNotFoundException;

public class UserNotFoundException extends EntityNotFoundException {

    private static final long serialVersionUID = 1L;

    public UserNotFoundException(String message) {
        super(message);
    }
    
    public UserNotFoundException(Long userId) {
        this(String.format("There is no user account with code %d", userId));
    }

}
