package iit.rectCondition.PC;

public class Consomateur extends Thread {

	protected Tampon tampon;

	public Consomateur(Tampon tampon) {
		this.tampon = tampon;

	}

	@Override
	public void run() {

		 while (true) {
		try {
			int val = tampon.take();
			System.out.println("Consomateur :take " + val);
			sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		 }
	}

}
