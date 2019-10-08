package Semaphore.iit;

import java.util.concurrent.Semaphore;

public class Avion {
	private int nbrPlace;

	protected Semaphore semaphore;

	public Avion(int nbrPlace) {
		super();
		this.nbrPlace = nbrPlace;
		semaphore = new Semaphore(1, true);// par defaut refair
	}

	public void reserver() throws InterruptedException {
		if (nbrPlace > 0) {
			nbrPlace--;
		} else {
			System.out.println("Avion plain");
		}

	}

	public int getNbrPlace() {
		return nbrPlace;
	}

}
