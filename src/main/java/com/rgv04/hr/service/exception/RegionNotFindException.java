package com.rgv04.hr.service.exception;

public class RegionNotFindException extends EntidadeNaoEncontradaException {

	private static final long serialVersionUID = 1L;

	public RegionNotFindException(String message) {
		super(message);
	}

	public RegionNotFindException(Long regionId) {
		this(String.format("There is no registration of region with code %d", regionId));
	}

}