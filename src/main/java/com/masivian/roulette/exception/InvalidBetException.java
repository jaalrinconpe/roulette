package com.masivian.roulette.exception;

public class InvalidBetException extends RuntimeException {

	private static final long serialVersionUID = 2223529032617934521L;

	public InvalidBetException() {
		super();
	}

	public InvalidBetException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public InvalidBetException(String message, Throwable cause) {
		super(message, cause);
	}

	public InvalidBetException(String message) {
		super(message);
	}

	public InvalidBetException(Throwable cause) {
		super(cause);
	}

}
