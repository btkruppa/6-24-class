package com.revature.u.strings;

public class StringDriver {
	public static void main(String[] args) {
		String one = "hello";
		String two = "hello";
		// here one == two would be true
		
		String three = one.substring(1,4);
		System.out.println(three);
		
		System.out.println(three.equals("ell")); // here if we did == it would say false
		
		
		// Mutable strings
		StringBuilder sb = new StringBuilder("hello");
		
		sb.append(" updated"); // will mutate the string builder in memory
		
		System.out.println(sb);
	}
}
