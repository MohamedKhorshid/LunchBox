package com.augenblick.lunchbox.account.validator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component(value = "passwordValidator")
public class PasswordValidator implements Validator<String> {
	
	private final static int MIN_PWD_LENGTH = 8;
	
	public List<ValidationError> validate (String password) {
		List<ValidationError> errors = new ArrayList<>();
		
		boolean passwordShort = password.length() < MIN_PWD_LENGTH;
		
		if(passwordShort) {
			errors.add(new ValidationError(ErrorCodes.PASSWORD_TOO_SHORT, new Object[] {MIN_PWD_LENGTH}));
		}
		
		return errors;
	}
}
