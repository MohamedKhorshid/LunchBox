
package com.augenblick.lunchbox.account.data.client;

public interface IAccountDAO {

	void createAccount(String email, String passwordHash);

}
