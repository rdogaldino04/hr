package com.rgv04.hr.domain.exception;

import com.rgv04.hr.exception.EntityNotFoundException;

public class CountryNotFoundException extends EntityNotFoundException {

	private static final long serialVersionUID = 1L;

	public CountryNotFoundException(String message) {
		super(message);
	}
	
}