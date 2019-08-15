package com.revature.services;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.revature.dtos.Credential;
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

	public User login(Credential cred) {
		User u = ur.findByUsernameAndPassword(cred.getUsername(), cred.getPassword());

		if (u != null) {
			HttpServletRequest req = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
					.getRequest();
			req.getSession().setAttribute("user", u);
		}
		return u;
	}
}
