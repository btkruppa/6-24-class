package com.revature.za.compare;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.revature.d.objects.Ball;

public class CompareDriver {
	
	public static void main(String[] args) {
		List<Ball> li = new ArrayList<>();
		li.add(new Ball("blue", 5, "relt", 15));
		li.add(new Ball("pink", 6, "rubber", 8));
		li.add(new Ball("black", 15, "ants", 30));
		li.add(new Ball("blue", 23, "plastic", 23));
		li.add(new Ball("orange", 18, "rubber", 22));
		li.add(new Ball("red", 5, "ants", 23));
		li.add(new Ball("green", 5, "rubber", 9));
		li.add(new Ball("green", 23, "felt", 5));
		li.add(new Ball("rainbow", 12, "ceramic", 15));
		
		Collections.sort(li);
		li.forEach(ball -> {
			System.out.println(ball);
		});
		
		System.out.println("\n\nBy Color");
		li.sort(new BallColorComparator());
		li.forEach(ball -> { 
			System.out.println(ball);
		});
		
		System.out.println("\n\nBy Material");
		li.sort((one, two) -> one.getMaterial().compareTo(two.getMaterial()));
		li.forEach(ball -> {
			System.out.println(ball);
		});
	}
}
