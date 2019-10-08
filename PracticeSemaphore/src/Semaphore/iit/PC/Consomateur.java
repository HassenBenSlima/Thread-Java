package Semaphore.iit.PC;

public class Consomateur implements Runnable {
	
	protected Tampon tampon;
	public  Consomateur(Tampon tampon) {
		this.tampon = tampon;

	}

	
	@Override
	public void run() {

		while(true) {
			try {
				tampon.consume();
				} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	
}
