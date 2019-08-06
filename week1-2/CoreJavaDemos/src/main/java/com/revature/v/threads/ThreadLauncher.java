package com.revature.v.threads;

public class ThreadLauncher {
	public static void main(String[] args) {
		
		Thread t1 = new BasicThread();
		t1.start();
		
		Thread t2 = new Thread(new BasicRunnable());
		t2.start();
		while(true) {
			System.out.println("hello from main thread");
		}
	}
}
