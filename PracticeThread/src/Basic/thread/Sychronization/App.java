package Basic.thread.Sychronization;

import java.util.Scanner;

class Processor extends Thread {

	private volatile boolean running = true;
	

	public boolean isRunning() {
		return running;
	}

	public void setRunning(boolean running) {
		this.running = running;
	}

	@Override
	public void run() {
		while (running) {
			System.out.println("Hello");

			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}
	
	public void shutdown() {
		running=false;
	}
}

public class App {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Processor proc = new Processor();
		proc.start();
		
		System.out.println("Press return to stop ...");
		Scanner scanner =new Scanner(System.in);
		scanner.nextLine();
		System.out.println(proc.isRunning());
		proc.shutdown();
		System.out.println(proc.isRunning());
	}

}
