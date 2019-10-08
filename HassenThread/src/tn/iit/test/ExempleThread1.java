package tn.iit.test;

public class ExempleThread1 implements  Runnable {
 
	private String toSay;
	private int toWait;

	public ExempleThread1(String toSay,int toWait) {
		this.toSay = toSay;
		this.toWait = toWait;
	}

	public void run() {
		for (int i = 1; i < 10; i++){
			System.out.println(i + " " + toSay);
			
			try {
				Thread.sleep(toWait);
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
	}

	public static void main(String args[]) {
		Thread thread1, thread2, thread3;
		thread1 =new Thread( new ExempleThread1("Hello ",5000));
		thread2 =new Thread( new ExempleThread1("World ",5000));
		thread3 = new Thread(new ExempleThread1("and Everybody ",5000));
		thread1.start();
		thread2.start();
		thread3.start();
		try {
			thread3.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Fin du programme");

	}
}