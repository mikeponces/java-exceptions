package com.pluralsight.exceptions;

public class CustomException extends Exception {

	private static final long serialVersionUID = 1L;

	public CustomException(String message) {
		super(message);
	}

	public CustomException(String message, Exception cause) {
		super(message, cause);
	}
}
