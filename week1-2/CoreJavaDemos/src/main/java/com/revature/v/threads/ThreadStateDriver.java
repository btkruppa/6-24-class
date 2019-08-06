package com.revature.v.threads;

public class ThreadStateDriver {
	
	public static synchronized void blockingMethod() {
		System.out.println("blocking method started");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("blocking method ended");
	}
	
	public static void main(String[] args) throws InterruptedException {
		
		Thread t1 = new Thread(() -> {
			System.out.println("t1 stated");
			while(true) {
				
			}
		});
		
		System.out.println(t1.getState());
		t1.start(); // will be runnable as soon as it is started
		System.out.println(t1.getState());
		
		Thread t2 = new Thread(() -> {
			System.out.println("t2 started and will now wait for 3 seconds");
			ThreadStateDriver.blockingMethod();
			System.out.println("t2 is done");
		});
		t2.start();
		
		Thread t3 = new Thread(() -> {
			System.out.println("t3 started and will now wait for t2 to finish");
			try {
				t2.join(); // wait until t2 is no longer alive
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("t3 done");
		});
		t3.start();
		
		Thread.sleep(1000);
		System.out.println(t2.getState());
		System.out.println(t3.getState());
		
		Thread t4 = new Thread(() -> {
			System.out.println("t4 started and will now call blocking method");
			ThreadStateDriver.blockingMethod();
			System.out.println("t4 is done");
		});
		t4.start();
		
		Thread.sleep(1000);
		System.out.println(t4.getState());

		
		Thread.sleep(3000);
		System.out.println(t2.getState());
	}
}
