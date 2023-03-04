package com.rgv04.hr.domain.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CountryFilter {

    private String id;

    private String name;

    private Long regionId;

    private String regionName;

}
