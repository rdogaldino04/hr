package com.rgv04.hr.domain.region;

import com.rgv04.hr.exception.EntityNotFoundException;

public class RegionNotFoundException extends EntityNotFoundException {

	private static final long serialVersionUID = 1L;

	public RegionNotFoundException(String message) {
		super(message);
	}

	public RegionNotFoundException(Long regionId) {
		this(String.format("There is no registration of region with code %d", regionId));
	}
	
	public RegionNotFoundException(Long regionId, String countryId) {
		this(String.format("There is no registration of region with code %d and country with code %s", regionId, countryId));
	}

}