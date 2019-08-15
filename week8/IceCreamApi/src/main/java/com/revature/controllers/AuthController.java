package com.revature.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.dtos.Credential;
import com.revature.models.User;
import com.revature.services.UserService;

@RestController
public class AuthController {

	@Autowired
	private UserService us;

	@PostMapping("/login")
	public User login(@RequestBody Credential cred) {
		return us.login(cred);
	}

	@GetMapping("/check-auth")
	public User checkAuth(HttpServletRequest req) {
		return (User) req.getSession().getAttribute("user");
	}
}
