package com.augenblick.lunchbox.account.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.augenblick.lunchbox.account.service.client.IAccountService;

@RestController
@RequestMapping("/accounts")
public class AccountController {
	
	@Autowired
	private IAccountService accountService;

	@PostMapping
	public void registerNewAccount(String email, String password) {
		System.out.println("inside account service");
		
		accountService.createAccount(email, password);
	}
}
