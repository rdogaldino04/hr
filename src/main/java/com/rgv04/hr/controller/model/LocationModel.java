package com.rgv04.hr.controller.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LocationModel {

	private Long id;

	private String streetAddress;

	private String postalCode;

	private String city;

	private String stateProvince;

	private CountryModel country;

}
