package com.revature.routers;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import com.revature.daos.UserDao;

public class UserRouter
		implements BeanNameAware, BeanFactoryAware, ApplicationContextAware, InitializingBean, DisposableBean {
	private UserDao ud;

	public UserRouter(UserDao ud) {
		super();
		this.ud = ud;
	}

	public UserRouter() {
		super();
		// TODO Auto-generated constructor stub
		System.out.println("Instantiation");
	}

	public String findById(int id) {
		return ud.findById(id);
	}

	public UserDao getUd() {
		return ud;
	}

	public void setUd(UserDao ud) {
		System.out.println("populating properties");
		this.ud = ud;
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		System.out.println("app context aware");
	}

	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		System.out.println("bean factory aware");
	}

	@Override
	public void setBeanName(String name) {
		System.out.println("bean name aware: name is " + name);
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("after properties set");
	}

	public void customInit() {
		System.out.println("custom init");
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("destroy");
	}
	
	public void customDestroy() {
		System.out.println("custom destroy");
	}

}
