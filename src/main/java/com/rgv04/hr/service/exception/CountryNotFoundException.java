package com.rgv04.hr.service.exception;

public class CountryNotFoundException extends EntityNotFoundException {

	private static final long serialVersionUID = 1L;

	public CountryNotFoundException(String message) {
		super(message);
	}
	
}