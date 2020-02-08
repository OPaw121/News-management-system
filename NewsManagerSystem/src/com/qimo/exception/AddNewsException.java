package com.qimo.exception;

public class AddNewsException extends Exception {

	private static final long serialVersionUID = 1L;

	public AddNewsException() {
		super();
	}

	public AddNewsException(String message, Throwable cause) {
		super(message, cause);
	}

	public AddNewsException(String message) {
		super(message);
	}

	public AddNewsException(Throwable cause) {
		super(cause);
	}

}
