package com.practice.csa.exception;

public class CarNotFoundByIdException extends RuntimeException{

	private String message;

	public CarNotFoundByIdException(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
	
	
}
