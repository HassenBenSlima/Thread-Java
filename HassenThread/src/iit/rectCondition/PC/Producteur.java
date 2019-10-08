package iit.rectCondition.PC;

public class Producteur extends Thread {

	protected Tampon tampon;

	public Producteur(Tampon tampon) {
		this.tampon = tampon;
	}

	@Override
	public void run() {
		int val = 0;
		while (true) {
			try {

				tampon.put(val);
				System.out.println("Prod: Ajout de " + val);
				sleep(1000);
			} catch (Exception e) {
				e.printStackTrace();
			}
		
			val++;
			}
		
	}

}
