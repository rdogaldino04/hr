package com.rgv04.hr.controller.model;

import lombok.Data;

@Data
public class LocationModel {

	private Long id;

	private String streetAddress;

	private String postalCode;

	private String city;

	private String stateProvince;

	private CountryModel country;

}
