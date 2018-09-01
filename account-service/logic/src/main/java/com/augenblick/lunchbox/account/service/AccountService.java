
package com.augenblick.lunchbox.account.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.augenblick.lunchbox.account.data.client.IAccountDAO;
import com.augenblick.lunchbox.account.service.client.IAccountService;
import com.augenblick.lunchbox.account.service.validator.EmailValidator;

@Component
public class AccountService implements IAccountService {
	
	@Autowired
	private IAccountDAO accountDAO;

	@Override
	public void createAccount(String email, String password) {
		new EmailValidator().validate(email);
		new EmailValidator().validate(password);
		
		String passwordHash = password;
		
		accountDAO.createAccount(email, passwordHash);
		
	}

}
