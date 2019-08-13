package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.User;
import com.revature.repos.UserRepo;

@Service
public class UserService {
	@Autowired
	private UserRepo ur;

	public List<User> findAll() {
		return ur.findAll();
	}

	public User findById(int id) {
		return ur.getOne(id);
	}

	public User findByUsername(String username) {
		return ur.findByUsername(username);
	}

	public User save(User user) {
		return ur.saveAndFlush(user);
	}
}
