package producteurConsommateur;

public class Producteur extends Thread {

	private Tampon tampon;

	public Producteur(Tampon tampon) {
		this.tampon = tampon;
	}

	@Override
	public void run() {
		int val = 0;
		while (true) {
			tampon.put(val);
			System.out.println("Prod: Ajout de "+val);
			val++;
		}

	}
}
