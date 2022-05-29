package com.rgv04.hr.model.filter;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LocationFilter {

	private Long locationId;

	private String streetAddress;

	private String postalCode;

	private String city;

	private String stateProvince;

	private String countryId;

	private String countryName;

}
