package Semaphore.iit.PC;

public class Producteur implements Runnable {

	protected Tampon tampon;

	public  Producteur(Tampon tampon) {
		this.tampon = tampon;
	}

	
	@Override
	public void run() {

		while (true) {
			try {
				tampon.produce();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
