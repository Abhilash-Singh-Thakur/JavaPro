package com.student.test.exception;

public class AppException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private String message;

	public AppException(String message) {
		super();
		this.message = message;
	}

	@Override
	public String getMessage() {
		return message;
	}

}
