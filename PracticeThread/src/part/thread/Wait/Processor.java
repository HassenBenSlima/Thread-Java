package part.thread.Wait;

import java.util.Scanner;

public class Processor {
	
	public void produce() throws InterruptedException {
		synchronized (this) {
			System.out.println("Producer thread running ....");
			wait();
			System.out.println("Resumed.");
		}

	}

	public void consume() throws InterruptedException {
		Scanner scanner =new Scanner(System.in);
		Thread.sleep(2000);
		
		synchronized (this) {
			System.out.println("Waiting for return key.");
			scanner.nextLine();
			System.out.println("Return key pressed");
			notify();
			for (int i = 0; i <10; i++) {
				System.out.println("HAssen");				
			}
			Thread.sleep(5000);

		}
	}

}
