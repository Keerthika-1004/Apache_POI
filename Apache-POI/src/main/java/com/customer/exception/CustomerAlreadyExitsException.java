package com.customer.exception;

public class CustomerAlreadyExitsException extends RuntimeException {

	private String errorMessage;

	public CustomerAlreadyExitsException() {

	}

	public CustomerAlreadyExitsException(String errorMessage) {
		super(errorMessage);

		// calling the constructor of parent Exception

		this.errorMessage = errorMessage;

	}

}
