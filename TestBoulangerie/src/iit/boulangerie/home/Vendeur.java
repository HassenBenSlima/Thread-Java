package iit.boulangerie.home;

import java.util.concurrent.ThreadLocalRandom;

public class Vendeur implements Runnable {

	Panier panier;

	public Vendeur(Panier panier) {
		this.panier = panier;
	}

	@Override
	public void run() {
		while (true) {
			int n = ThreadLocalRandom.current().nextInt(1, 4);

			try {
				panier.splein.acquire();
				panier.smutex.acquire();
				System.out.println(" Seller able to retire: " + n + " Baguette");
				while (n > 0) {

					Baguette b = panier.retirer();
					System.out.println("Retirer :" + b.toString());
					n--;
				}
				System.out.println("Fin");
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				panier.smutex.release();
				panier.svide.release();
				try {
					Thread.sleep(300);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
