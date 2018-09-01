
package com.augenblick.lunchbox.account.data;

import org.springframework.stereotype.Component;

import com.augenblick.lunchbox.account.data.client.IAccountDAO;

@Component
public class AccountDAO implements IAccountDAO {

	@Override
	public void createAccount(String email, String passwordHash) {
		System.out.println("Saving new user " + email + " with password " + passwordHash);
	}

}
