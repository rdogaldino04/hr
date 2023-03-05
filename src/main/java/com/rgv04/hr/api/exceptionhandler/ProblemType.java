package com.rgv04.hr.api.exceptionhandler;
import lombok.Getter;

@Getter
public enum ProblemType {
	
	INVALID_DATA("/invalid-data", "Invalid data"),
	SYSTEM_ERROR("/system-error", "System error"),
	INVALID_PARAMETER("/invalid-parameter", "Invalid parameter"),
	INCOMPREHENSIBLE_MESSAGE("/incomprehensible-message", "Incomprehensible message"),
	RESOURCE_NOT_FOUND("/resource-not-found", "Resource not found"),
	ENTITY_IN_USE("/entity-in-use", "Entity in use"),
	ACCESS_DENIED("/access-denied", "Access denied"),
	BUSINESS_ERROR("/business-error", "Business rule violation");
		
	private String title;
	private String uri;
	
	ProblemType(String path, String title) {
		this.uri = "https://rgv.com.br" + path;
		this.title = title;
	}

}