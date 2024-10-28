package com.customer.exception;

public class CustomerOrderIdAlreadyExistsException extends RuntimeException {
	private String errorMessage;

	public CustomerOrderIdAlreadyExistsException() {

	}

	public CustomerOrderIdAlreadyExistsException(String errorMessage) {
		super();

		// calling the constructor of parent Exception

		this.errorMessage = errorMessage;

	}

	public String getMessage() {
		// TODO Auto-generated method stub
		return "customer order id already exists";
	}

}
