package com.rgv04.hr.domain.dto;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserWithPasswordInput extends UserInput {
    
    @NotBlank
    private String password;
    
}
