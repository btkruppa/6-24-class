package com.revature.driver;

import java.util.List;

import com.revature.dao.IceCreamDao;
import com.revature.dao.UserDao;
import com.revature.models.IceCream;

public class HibernateDriver {
	private static IceCreamDao iceCreamDao = new IceCreamDao();
	private static UserDao ud = new UserDao();

	public static void main(String[] args) {
//		IceCream ic = iceCreamDao.findById(8);
//		System.out.println(ic);

		// save
//		List<Flavor> flavors = new ArrayList<>();
//		flavors.add(new Flavor(2, null));
//		flavors.add(new Flavor(1, null));
//		flavors.add(new Flavor(5, null));
//		
//		IceCream ic = new IceCream(0, "Neopolitan", 
//				new Brand(0, "Blue Bunny"),
//				flavors,
//				new ArrayList<>()
//				);
//		System.out.println(iceCreamDao.save(ic));

		// update
//		List<Flavor> flavors = new ArrayList<>();
//		flavors.add(new Flavor(2, null));
//		
//		IceCream ic = new IceCream(8, "Neapolitan", 
//				new Brand(5, "Blue Bell"),
//				flavors,
//				new ArrayList<>()
//				);
//		System.out.println(iceCreamDao.update(ic));

		// add topping
//		iceCreamDao.addToppingToIceCream(8, 1);
//		IceCream ic = iceCreamDao.findById(8);
//		System.out.println(ic);

//		 remove topping
//		iceCreamDao.removeToppingFromIceCream(8, 4);
//		IceCream ic = iceCreamDao.findById(8);
//		System.out.println(ic);

		// login
//		User u = ud.findByUsernameAndPassword("btkruppa", "pass");
//		System.out.println(u);

		// find icecream by flavor name
		List<IceCream> iceCream = iceCreamDao.findByFlavorName("vanilla");
		iceCream.forEach(ele -> System.out.println(ele));

//		iceCreamDao.findByFlavorNameCriteria("vanilla");

//		List<IceCream> iceCream = iceCreamDao.findByBrandName("cold stone");
//		iceCream.forEach(ele -> System.out.println(ele));
	}
}
