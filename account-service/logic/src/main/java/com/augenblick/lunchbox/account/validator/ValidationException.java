package com.augenblick.lunchbox.account.validator;

import java.util.List;

public class ValidationException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	private List<ValidationError> errors;

	public ValidationException(List<ValidationError> errors) {
		this.errors = errors;
	}
	
	public List<ValidationError> getErrors() {
		return errors;
	}
	
	@Override
	public String getMessage() {
		return "Validation failed with error codes: " + errors;
	}

}
