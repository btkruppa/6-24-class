package com.revature.driver;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.routers.UserRouter;

public class SpringDriver {
	public static void main(String[] args) {
		// i don't want to create my own, I want spring to provide one
//		UserRouter ur = new UserRouter();
//		System.out.println(ur.findById(1));

		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");

		UserRouter ur = (UserRouter) ac.getBean("User Router");
		System.out.println("in use");
		System.out.println(ur.findById(1));

		((AbstractApplicationContext) ac).close();

	}
}
