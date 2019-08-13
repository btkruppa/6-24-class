package com.revature.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.revature.models.User;
import com.revature.util.SessionUtil;

public class UserDao {
	private SessionFactory sf = SessionUtil.getSessionFactory();

	public User findByUsernameAndPassword(String username, String password) {
		Session s = sf.openSession();
		Transaction t = s.beginTransaction();

		Query q = s.createQuery("FROM User u WHERE u.username = :username AND u.password = :pass");
		q.setString("username", username);
		q.setString("pass", password);
		List<User> users = (List<User>) q.list();
		if (users.size() > 0) {
			t.commit();
			s.close();
			return users.get(0);
		} else {
			t.commit();
			s.close();
			return null;
		}
	}
}
