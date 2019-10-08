package tp1.ex1;

public class Vendeur implements Runnable {

	private Panier panier;

	public Vendeur(Panier panier) {
		this.panier = panier;
	}

	@Override
	public void run() {
		while (true) {
			try {
				panier.splein.acquire();
				panier.smutex.acquire();
				Baguette b = panier.retirer();
				System.out.println("Retirer ::" + b);
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				panier.smutex.release();
				
				panier.svide.release();
			}
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
