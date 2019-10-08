package Semaphore.iit.PC;

public class Main {

	public static void main(String[] args) {

		Tampon tampon = new Tampon(10);
		Producteur producteur = new Producteur(tampon);
		Consomateur consomateur = new Consomateur(tampon);

		Thread p = new Thread(producteur);
		Thread c = new Thread(consomateur);
		p.start();
		c.start();
	}

}
