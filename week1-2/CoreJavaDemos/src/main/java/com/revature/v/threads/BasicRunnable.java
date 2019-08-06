package com.revature.v.threads;

public class BasicRunnable implements Runnable {
	@Override
	public void run() {
		while(true) {
			System.out.println("hello from basic runnable");
		}
	}
}
