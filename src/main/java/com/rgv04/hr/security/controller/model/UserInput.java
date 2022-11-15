package com.rgv04.hr.security.controller.model;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserInput {
    
    @NotBlank
    private String name;

    @NotBlank
    private String username;
    
}
