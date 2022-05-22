package com.rgv04.hr.service.exception;

public class RegionNotFindException extends EntityNotFoundException {

	private static final long serialVersionUID = 1L;

	public RegionNotFindException(String message) {
		super(message);
	}

	public RegionNotFindException(Long regionId) {
		this(String.format("There is no registration of region with code %d", regionId));
	}
	
	public RegionNotFindException(Long regionId, String countryId) {
		this(String.format("There is no registration of region with code %d and country with code %s", regionId, countryId));
	}

}