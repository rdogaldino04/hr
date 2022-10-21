package com.rgv04.hr.domain.region;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class RegionInput {

    @NotBlank
    private String name;

}