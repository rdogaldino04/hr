package com.rgv04.hr.controller.model;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class RegionInput {

    @NotBlank
    private String name;

}