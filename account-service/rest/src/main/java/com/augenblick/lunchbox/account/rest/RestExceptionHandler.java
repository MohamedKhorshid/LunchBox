package com.augenblick.lunchbox.account.rest;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.augenblick.lunchbox.account.validator.ValidationException;

@RestControllerAdvice
public class RestExceptionHandler {
	
	@Autowired
	private MessageSource resourceBundle;

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(ValidationException.class)
	public RestResponse handleValidationException(ValidationException validationException) {
		
		List<String> messages = new ArrayList<>();
		
		validationException.getErrors().forEach(error -> {
			messages.add(resourceBundle.getMessage(error.getMessage(), error.getArgs(), new Locale("en")));
		});
		
		return new RestResponse(messages.toArray(new String[0]));
	}
}
