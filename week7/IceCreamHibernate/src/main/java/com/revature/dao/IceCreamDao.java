package com.revature.dao;

import java.util.List;
import java.util.stream.Collectors;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.revature.models.IceCream;
import com.revature.models.Topping;
import com.revature.util.SessionUtil;

public class IceCreamDao {

	private SessionFactory sf = SessionUtil.getSessionFactory();

	public int save(IceCream ic) {
		Session s = sf.openSession();
		Transaction t = s.beginTransaction();

		s.save(ic);

		t.commit();
		s.close();
		return ic.getIceCreamId();
	}

	public IceCream update(IceCream ic) {
		Session s = sf.openSession();
		Transaction t = s.beginTransaction();

//		IceCream ic2 = (IceCream) s.get(IceCream.class, ic.getIceCreamId());

		s.update(ic);

		t.commit();
		s.close();
		return ic;
	}

	public IceCream findById(int id) {
		Session s = sf.openSession();

		IceCream ic = (IceCream) s.get(IceCream.class, id);
	
		// Flavors is a lazy intialized field
		// meaning instead of the data we have a proxy
		// as long as we are in the session we can access that data freely
		// but if the data is not accessed or initialized before the session is closed
		// we will get LazyInitializationException
		Hibernate.initialize(ic.getFlavors());
		Hibernate.initialize(ic.getToppings());
		Hibernate.initialize(ic.getBrand());
		s.close();

		return ic;
	}

	public void addToppingToIceCream(int iceCreamId, int toppingId) {
		Session s = sf.openSession();
		Transaction t = s.beginTransaction();

		// when we retreive the icecream it will be persistent until the
		// transaction closes, if we modify the object, hibernate will automatically
		// update the database as well
		// this is known as Automatic Dirty Checking
		IceCream ic = (IceCream) s.get(IceCream.class, iceCreamId);
		Topping topping = (Topping) s.get(Topping.class, toppingId);

		ic.getToppings().add(topping);

		// if
//		ic.setName("Updated"); 

		t.commit();
		s.close();
	}
	
	
	public void removeToppingFromIceCream(int iceCreamId, int toppingId) {
		Session s = sf.openSession();
		Transaction t = s.beginTransaction();

		// when we retreive the icecream it will be persistent until the
		// transaction closes, if we modify the object, hibernate will automatically
		// update the database as well
		// this is known as Automatic Dirty Checking
		IceCream ic = (IceCream) s.get(IceCream.class, iceCreamId);
		Topping topping = (Topping) s.get(Topping.class, toppingId);

		ic.getToppings().remove(topping);

		// if
//		ic.setName("Updated"); 

		t.commit();
		s.close();
	}

	public List<IceCream> findByFlavorName(String flavorName) {
		Session s = sf.openSession();
		Transaction t = s.beginTransaction();

		String queryString = "SELECT ic FROM IceCream ic JOIN ic.flavors f WHERE LOWER(f.name) = LOWER(:name)";

		Query q = s.createQuery(queryString);
		q.setString("name", flavorName);
		List<IceCream> iceCream = q.list();
		iceCream.forEach(ic -> {
			Hibernate.initialize(ic.getFlavors());
			Hibernate.initialize(ic.getToppings());
			Hibernate.initialize(ic.getBrand());
		});
		t.commit();
		s.close();
		return iceCream;
	}
	
	public List<IceCream> findByBrandName(String brandName) {
		Session s = sf.openSession();
		Transaction t = s.beginTransaction();

		String queryString = "SELECT ic FROM IceCream ic WHERE " +
				"LOWER(ic.brand.name) = LOWER(:brand)";

		Query q = s.createQuery(queryString);
		
		// we could also used named queries but I'm not the biggest fan
//		Query q = s.getNamedQuery("findByBrandName");
		
		q.setString("brand", brandName);
		List<IceCream> iceCream = q.list();
		iceCream.forEach(ic -> {
			Hibernate.initialize(ic.getFlavors());
			Hibernate.initialize(ic.getToppings());
			Hibernate.initialize(ic.getBrand());
		});
		t.commit();
		s.close();
		return iceCream;
	}

	public List<IceCream> findByFlavorNameCriteria(String flavorName) {
		Session s = sf.openSession();
		Transaction t = s.beginTransaction();

		Criteria c = s.createCriteria(IceCream.class);
		c.createAlias("flavors", "f");
		c.add(Restrictions.ilike("f.name", flavorName));
		List<IceCream> iceCream = c.list();
		iceCream.forEach(ele -> System.out.println(ele));
		t.commit();
		s.close();
		return iceCream;
	}
}
