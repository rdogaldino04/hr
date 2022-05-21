package com.rgv04.hr.model.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegionDTO {

	private Long id;

	private String name;

	private List<CountryDTO> countries = new ArrayList<>();

}
