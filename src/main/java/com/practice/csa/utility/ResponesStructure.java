package com.practice.csa.utility;

import ch.qos.logback.core.pattern.util.RegularEscapeUtil;

public class ResponesStructure<T> {

	private int statusCode;
	private String message;
	private T data;

	public int getStatusCode() {
		return statusCode;
	}

	public ResponesStructure<T> setStatusCode(int statusCode) {
		this.statusCode = statusCode;
		return this;
	}

	public String getMessage() {
		return message;
	}

	public ResponesStructure<T> setMessage(String message) {
		this.message = message;
		return this;
	}

	public T getData() {
		return data;
	}

	public ResponesStructure<T> setData(T data) {
		this.data = data;
		return this;
	}

}
