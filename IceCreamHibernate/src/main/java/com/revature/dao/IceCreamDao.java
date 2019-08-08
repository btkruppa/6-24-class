package com.revature.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.revature.models.IceCream;
import com.revature.util.SessionUtil;

public class IceCreamDao {
	
	private SessionFactory sf = SessionUtil.getSessionFactory();
	
	public IceCream findById(int id) {
		Session s = sf.openSession();
		
		IceCream ic = (IceCream) s.get(IceCream.class, id);
		System.out.println(ic);
		s.close();
		
		return ic;
	}
}
