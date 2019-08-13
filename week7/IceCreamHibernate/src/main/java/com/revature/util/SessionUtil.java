package com.revature.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class SessionUtil {
	private static SessionFactory sf;

	static {
		Configuration configuration = new Configuration().configure();
		configuration.setProperty("hibernate.connection.url",
				"jdbc:postgresql://" + System.getenv("ICE_CREAM_URL") + ":5432/ice_cream");
		configuration.setProperty("hibernate.connection.username", System.getenv("ICE_CREAM_USERNAME"));
		configuration.setProperty("hibernate.connection.password", System.getenv("ICE_CREAM_PASSWORD"));
//		configuration.setProperty("hibernate.default_schema", System.getenv("ICE_CREAM_SCHEMA"));

		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties()).build();
		sf = configuration.buildSessionFactory(serviceRegistry);
	}

	public static SessionFactory getSessionFactory() {
		return sf;
	}

}
