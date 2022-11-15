package com.rgv04.hr.security.controller.model;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserWithPasswordInput extends UserInput {
    
    @NotBlank
    private String password;
    
}
