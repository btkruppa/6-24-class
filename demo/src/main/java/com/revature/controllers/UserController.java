package com.revature.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.revature.models.User;

@Controller
@RequestMapping("/users")
public class UserController {

	@GetMapping
	@ResponseBody // tells spring to convert resp to json
	public List<User> findAll() {
		System.out.println("finding all users");
		List<User> users = new ArrayList<>();
		users.add(new User(1, "blake", "pass", "blake", "kruppa", "234324", "welrjka", "admin"));
		users.add(new User(2, "matt", "pass", "matt", "a", "32432432", "lwekjrwel", "associate"));
		return users;
	}

	@GetMapping("/{id}")
	@ResponseBody // tells spring to convert resp to json
	public User findById(@PathVariable int id) {
		return new User(id, "matt", "pass", "matt", "a", "32432432", "lwekjrwel", "associate");
	}

	@GetMapping("/username/{username}")
	@ResponseBody // tells spring to convert resp to json
	public User findByUsername(@PathVariable String username) {
		return new User(1, username, "pass", "matt", "a", "32432432", "lwekjrwel", "associate");
	}

	@PostMapping
	@ResponseBody
	public User save(@RequestBody User user) {
		System.out.println(user);
		user.setUserId(1);
		return user;
	}

}
