package com.practice.csa.exception;

public class ServiceNotFoundByIdException extends RuntimeException {

	private String message;

	public ServiceNotFoundByIdException(String message) {
		this.message = message;
	}
	
	@Override
	public String getMessage() {
		return message;
	}
	
	
}
