package com.augenblick.lunchbox.account.validator;

public class ValidationError {
	
	private String message;

	public ValidationError(String message) {
		this.message = message;
	}
	
	public String getMessage() {
		return message;
	}
	
	@Override
	public String toString() {
		return message;
	}

}
