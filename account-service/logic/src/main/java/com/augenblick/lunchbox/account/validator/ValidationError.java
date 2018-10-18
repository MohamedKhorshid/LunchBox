package com.augenblick.lunchbox.account.validator;

public class ValidationError {
	
	private String message;
	private Object[] args;

	public ValidationError(String message) {
		this.message = message;
	}
	
	public ValidationError(String message, Object[] args) {
		this.message = message;
		this.args = args;
	}
	
	public String getMessage() {
		return message;
	}

	public Object[] getArgs() {
		return args;
	}
	
	

}
