
package com.augenblick.lunchbox.account.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.augenblick.lunchbox.account.data.client.AccountRepository;
import com.augenblick.lunchbox.account.model.Account;
import com.augenblick.lunchbox.account.service.client.IAccountService;
import com.augenblick.lunchbox.account.validator.EmailValidator;
import com.augenblick.lunchbox.account.validator.PasswordValidator;
import com.augenblick.lunchbox.account.validator.ValidationError;
import com.augenblick.lunchbox.account.validator.ValidationException;

@Component
public class AccountService implements IAccountService {
	
	@Autowired
	private AccountRepository accountDAO;
	
	@Autowired
	private EmailValidator emailValidator;
	
	@Autowired
	private PasswordValidator passwordValidator;

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
