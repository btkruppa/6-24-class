package com.revature.za.compare;

import java.util.Comparator;

import com.revature.d.objects.Ball;

public class BallColorComparator implements Comparator<Ball> {

	@Override
	public int compare(Ball o1, Ball o2) {
		return o1.getColor().compareTo(o2.getColor());
	}

}
