package com.revature.v.threads;

/**
 * I should probably not extend thread, I should implement
 * runnable
 * @author btkru
 *
 */
public class BasicThread extends Thread {
	@Override
	public void run() {
		while (true) {
			System.out.println("hello from basic thread");
		}
	}
}
