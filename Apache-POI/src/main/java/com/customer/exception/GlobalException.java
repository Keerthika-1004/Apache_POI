package com.customer.exception;

import java.util.HashMap;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException {
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public HashMap<String, String> handleInvalidArgument(MethodArgumentNotValidException ex) {
		HashMap<String, String> errors = new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach((error) -> {
			String fieldName = ((FieldError) error).getField();
			String errorMessage = error.getDefaultMessage();
			errors.put(fieldName, errorMessage);

		});
		return errors;
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(CustomerAlreadyExitsException.class)
	public HashMap<String, String> handleBuisnessException(CustomerAlreadyExitsException ex) {
		HashMap<String, String> errors = new HashMap<>();
		errors.put("error message", ex.getMessage());
		return errors;
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(CustomerOrderIdAlreadyExistsException.class)
	public HashMap<String, String> handleBuisnessException(CustomerOrderIdAlreadyExistsException ex) {
		HashMap<String, String> errors = new HashMap<>();
		errors.put("errorMessage", ex.getMessage());
		return errors;
	}

}
