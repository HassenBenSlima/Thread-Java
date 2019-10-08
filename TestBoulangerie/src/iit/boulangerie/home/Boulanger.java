package iit.boulangerie.home;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Boulanger implements Runnable {
	private CyclicBarrier c;
	private Panier panier;
	private int compteurBauguette;

	public Boulanger(Panier panier,CyclicBarrier cyc) {
		this.panier = panier;
		this.c=cyc;
	}

	@Override
	public void run() {

		while (true) {
			try {
				panier.svide.acquire();
				panier.smutex.acquire();
				Baguette baguette = new Baguette();
				panier.deposer(baguette);
				compteurBauguette++;
				System.out.println("depose :" + baguette.toString());
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				panier.smutex.release();
				panier.splein.release();

			}
			if (compteurBauguette % 10 == 0) {
				try {
					c.await();
				} catch (InterruptedException | BrokenBarrierException e) {
					e.printStackTrace();
				}
			}

			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
