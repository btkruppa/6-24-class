package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.revature.models.User;
import com.revature.services.UserService;

@Controller
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService us;

	@GetMapping
	@ResponseBody // tells spring to convert resp to json
	public List<User> findAll() {
		return us.findAll();
	}

	@GetMapping("/{id}")
	@ResponseBody // tells spring to convert resp to json
	public User findById(@PathVariable int id) {
		return us.findById(id);
	}

	@GetMapping("/username/{username}")
	@ResponseBody // tells spring to convert resp to json
	public User findByUsername(@PathVariable String username) {
		return us.findByUsername(username);
	}

	@PostMapping
	@ResponseBody
	public User save(@RequestBody User user) {
		return us.save(user);
	}

}
