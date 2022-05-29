package com.rgv04.hr.model.dto;

import lombok.Data;

@Data
public class LocationDTO {

	private Long id;

	private String streetAddress;

	private String postalCode;

	private String city;

	private String stateProvince;

	private CountryDTO country;

}
