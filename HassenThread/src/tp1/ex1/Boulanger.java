package tp1.ex1;

public class Boulanger implements Runnable {

	private Panier panier;

	public Boulanger(Panier panier) {
		this.panier = panier;
	}

	@Override
	public void run() {
		while (true) {
			Baguette b = new Baguette();
			try {
				panier.svide.acquire();
				panier.smutex.acquire();
				panier.deposer(b);
				System.out.println("Déposer ::" + b);
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				panier.smutex.release();
				
				panier.splein.release();
			}

			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
