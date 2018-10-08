
package com.augenblick.lunchbox.account.data;

import org.springframework.stereotype.Repository;

import com.augenblick.lunchbox.account.model.Account;

@Repository
public class AccountDAO {
	
	public void createAccount(Account account) {
		System.out.println("Saving new user " + account.getEmail() + " with password " + account.getPasswordHash());
	}

}
