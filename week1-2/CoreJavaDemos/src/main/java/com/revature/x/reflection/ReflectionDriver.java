package com.revature.x.reflection;

import java.lang.reflect.Field;

import com.revature.d.objects.Ball;

public class ReflectionDriver {
	public static void main(String[] args) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		Ball b = new Ball();
		
		System.out.println(b);
		Field[] fields = Ball.class.getDeclaredFields();
		
		for(Field f: fields) {
			System.out.println(f.getName());
		}
		
		Field col = Ball.class.getDeclaredField("color");
		
		col.setAccessible(true);
		col.set(b, "purpleish");
		System.out.println(b);
		
	}
}
