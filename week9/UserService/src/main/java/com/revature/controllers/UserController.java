package com.revature.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.User;

@RestController
@RequestMapping("/users")
public class UserController {

	private List<User> users = new ArrayList<>();

	public UserController() {
		users.add(new User(1, "Brenton", "Brenton@revature.com", "pass", "Larry Special"));
		users.add(new User(2, "Phong", "Phong@revature.com", "pass", "Island"));
		users.add(new User(3, "Carri", "Carri@revature.com", "pass", "Strawberry Gas"));
		users.add(new User(4, "Blake", "Blake@revature.com", "pass", "1907"));
	}

	@GetMapping
	public List<User> findAll() {
		return users;
	}

	@GetMapping("email/{emails}")
	public List<User> findByEmail(@PathVariable List<String> emails) {
		
		System.out.println(emails);
		return users.stream()
					.filter(user -> emails.contains(user.getEmail()))
					.collect(Collectors.toList());
	}
}
