package com.revature.driver;

import com.revature.dao.IceCreamDao;
import com.revature.models.IceCream;

public class HibernateDriver {
	private static IceCreamDao iceCreamDao = new IceCreamDao();

	public static void main(String[] args) {
		System.out.println("started");
		IceCream ic = iceCreamDao.findById(1);
	}
}
