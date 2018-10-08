package com.augenblick.lunchbox.account.validator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.augenblick.lunchbox.account.data.client.AccountRepository;
import com.augenblick.lunchbox.account.model.Account;

@Component
public class EmailValidator extends Validator<String> {
	
	@Autowired
	private AccountRepository accountRepository;
	
	public List<ValidationError> validate (String email) {
		List<ValidationError> errors = new ArrayList<>();
		
		Account account = accountRepository.findByEmail(email);
		
		if(account != null) {
			errors.add(new ValidationError(ErrorCodes.ACCOUNT_EMAIL_EXISTS));
		}
		
		return errors;
	}
}
