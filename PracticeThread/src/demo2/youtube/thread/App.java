package demo2.youtube.thread;

class Runner implements Runnable {

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println("Hello "+ i);
		
		
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	}

}
public class App {
	public static void main(String[] args) {
		
	
	Thread th1=new Thread(new Runner());
	Thread th2=new Thread(new Runner());

	th1.start();
	th2.start();
	
	}
}
