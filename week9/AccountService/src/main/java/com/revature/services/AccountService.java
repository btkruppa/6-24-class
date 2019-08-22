package com.revature.services;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.revature.intercomm.UserClient;
import com.revature.models.Account;
import com.revature.models.User;

@Service
public class AccountService {

	@Autowired
	private UserClient userClient;

	private List<Account> accounts = new ArrayList<>();

	public AccountService() {
		accounts.add(new Account(1, null, "Phong@revature.com", "Savings", 1));
		accounts.add(new Account(2, null, "Phong@revature.com", "Checking", 9001));
		accounts.add(new Account(3, null, "Larry@revature.com", "Savings", -5));
		accounts.add(new Account(4, null, "Blake@revature.com", "Savings", 5));
	}

	public List<Account> findAllFeign() {

		StringBuilder emails = new StringBuilder("");
		// get list of emails as comma seperated values
		for (int i = 0; i < accounts.size(); i++) {
			emails.append(accounts.get(i).getUserEmail());
			if (i != accounts.size() - 1) {
				emails.append(",");
			}
		}

		List<User> users = userClient.findByEmail(emails.toString());
		System.out.println(users);
		
		if (users == null) {
			HttpServletResponse res = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
					.getResponse();
			res.setStatus(206);
			return accounts;
		}

		// add users to the appropriate accounts
		accounts.forEach(acc -> {
			for (User u : users) {
				if (acc.getUserEmail().equals(u.getEmail())) {
					acc.setUser(u);
					break;
				}
			}
		});
		return accounts;
	}

	public List<Account> findAll() {

		StringBuilder emails = new StringBuilder("");
		// get list of emails as comma seperated values
		for (int i = 0; i < accounts.size(); i++) {
			emails.append(accounts.get(i).getUserEmail());
			if (i != accounts.size() - 1) {
				emails.append(",");
			}
		}
// first solution maybe less readable
//		String emails = accounts.stream().map(acc -> acc.getUserEmail()).reduce((cur, acc) -> {
//			return acc + ',' + cur;
//		}).get();
		System.out.println(emails);

		// send emails to server to get list of users with those emails
		RestTemplate rt = new RestTemplate();
		ResponseEntity<List<User>> users = rt.exchange("http://localhost:8014/users/email/" + emails, HttpMethod.GET,
				null, new ParameterizedTypeReference<List<User>>() {
				});
		System.out.println(users.getBody());

		// add users to the appropriate accounts
		accounts.forEach(acc -> {
			for (User u : users.getBody()) {
				if (acc.getUserEmail().equals(u.getEmail())) {
					acc.setUser(u);
					break;
				}
			}
		});
		return accounts;
	}

	public Account findById(int id) {
		return accounts.stream().filter(acc -> acc.getId() == id).findFirst().get();
	}
}
