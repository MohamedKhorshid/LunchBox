package com.augenblick.lunchbox.account.validator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class PasswordValidator extends Validator<String> {
	public List<ValidationError> validate (String password) {
		List<ValidationError> errors = new ArrayList<>();
		
		boolean passwordShort = password.length() < 8;
		
		if(passwordShort) {
			errors.add(new ValidationError(ErrorCodes.PASSWORD_TOO_SHORT));
		}
		
		return errors;
	}
}
