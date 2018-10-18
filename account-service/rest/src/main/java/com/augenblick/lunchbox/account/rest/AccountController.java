package com.augenblick.lunchbox.account.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.augenblick.lunchbox.account.model.Account;
import com.augenblick.lunchbox.account.service.client.IAccountService;

@RestController
@RequestMapping("/accounts")
public class AccountController {
	
	@Autowired
	private IAccountService accountService;

	@PostMapping
	public void registerNewAccount(String email, String password) {
		accountService.createAccount(email, password);
	}
	
	@GetMapping
	public Account getAccount(String email) {
		return accountService.getAccount(email);
	}
}
