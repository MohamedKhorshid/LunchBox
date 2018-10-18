
package com.augenblick.lunchbox.account.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.augenblick.lunchbox.account.data.client.AccountRepository;
import com.augenblick.lunchbox.account.model.Account;
import com.augenblick.lunchbox.account.service.client.IAccountService;
import com.augenblick.lunchbox.account.validator.ValidationError;
import com.augenblick.lunchbox.account.validator.ValidationException;
import com.augenblick.lunchbox.account.validator.Validator;

@Component
public class AccountService implements IAccountService {
	
	@Autowired
	private AccountRepository accountDAO;
	
	@Autowired
	@Qualifier(value = "emailValidator")
	private Validator<String> emailValidator;
	
	@Autowired
	@Qualifier (value = "passwordValidator")
	private Validator<String> passwordValidator;

	@Override
	public void createAccount(String email, String password) {
		List<ValidationError> errors = emailValidator.validate(email);
		
		if (errors != null && !errors.isEmpty()) {
			throw new ValidationException(errors);
		}
		
		errors = passwordValidator.validate(password);
		
		if (errors != null && !errors.isEmpty()) {
			throw new ValidationException(errors);
		}
		
		String passwordHash = password;
		
		Account account = new Account();
		account.setEmail(email);
		account.setPasswordHash(passwordHash);
		
		accountDAO.save(account);
		
	}
	
	@Override
	public Account getAccount(String email) {
		return accountDAO.findByEmail(email);
	}

}
