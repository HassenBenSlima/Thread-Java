package iit.boulangerie.home;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.Semaphore;

public class Panier {

	LinkedBlockingQueue<Baguette> bag;
	Semaphore svide;
	Semaphore splein;
	Semaphore smutex;

	public Panier() {
		this.bag = new LinkedBlockingQueue<>();
		svide = new Semaphore(Integer.MAX_VALUE, true);
		splein = new Semaphore(0, true);
		smutex = new Semaphore(1, true);
	}

	public void deposer(Baguette b) {
		bag.offer(b);
	}

	public Baguette retirer() {
		Baguette b = bag.poll();
		return b;
	}
}
