package com.qimo.exception;

public class FindNewsByIdException extends Exception {

	private static final long serialVersionUID = 1L;

	public FindNewsByIdException() {
		super();
	}

	public FindNewsByIdException(String message, Throwable cause) {
		super(message, cause);
	}

	public FindNewsByIdException(String message) {
		super(message);
	}

	public FindNewsByIdException(Throwable cause) {
		super(cause);
	}

}
