package com.revature.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.Account;

@RestController
@RequestMapping("/accounts")
public class AccountController {

	private List<Account> accounts = new ArrayList<>();

	public AccountController() {
		accounts.add(new Account(1, null, "Phong@revature.com", "Savings", 1));
		accounts.add(new Account(2, null, "Phong@revature.com", "Checking", 9001));
		accounts.add(new Account(3, null, "Larry@revature.com", "Savings", -5));
	}

	@GetMapping
	public List<Account> findAll() {
		return accounts;
	}
}
