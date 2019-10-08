package tp1.ex1;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.Semaphore;

public class Panier {

	private LinkedBlockingQueue<Baguette> bag = new LinkedBlockingQueue<>(20);
	protected Semaphore splein;
	protected Semaphore svide;
	protected Semaphore smutex;

	public Panier() {
		this.splein = new Semaphore(0, true);
		this.svide = new Semaphore(20, true);
		this.smutex = new Semaphore(1, true);

	}

	public Baguette retirer() {
		Baguette b = bag.poll();
		return b;
	}

	public void deposer(Baguette b) {
		bag.offer(b);
	}

	public static void main(String[] args) {
		Panier panier = new Panier();
		Vendeur vendeur = new Vendeur(panier);
		Boulanger boulanger = new Boulanger(panier);

		Thread p = new Thread(vendeur);
		Thread c = new Thread(boulanger);
		p.start();
		c.start();
	}

}
