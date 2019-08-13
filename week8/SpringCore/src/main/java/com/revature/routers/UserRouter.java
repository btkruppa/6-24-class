package com.revature.routers;

import com.revature.daos.UserDao;

public class UserRouter {
	private UserDao ud;

	public UserRouter(UserDao ud) {
		super();
		this.ud = ud;
	}

	public UserRouter() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String findById(int id) {
		return ud.findById(id);
	}
}
