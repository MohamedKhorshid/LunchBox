package com.augenblick.lunchbox.account.service.client;

import com.augenblick.lunchbox.account.model.Account;

public interface IAccountService {
	
	void createAccount(String email, String password);

	Account getAccount(String email);

}
