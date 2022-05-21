package com.rgv04.hr.model.filter;

import com.rgv04.hr.model.dto.CountryDTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegionFilter {

	private Long regionId;

	private String name;
	
	private CountryDTO country;

}
