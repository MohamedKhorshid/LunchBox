package com.augenblick.lunchbox.account.rest;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account")
public class AccountController {

	@PostMapping
	public void registerNewAccount() {
		System.out.println("inside account service");
	}
}
