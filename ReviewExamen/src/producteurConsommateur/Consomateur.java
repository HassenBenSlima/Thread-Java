package producteurConsommateur;

public class Consomateur implements Runnable {

	private Tampon tampon;

	public Consomateur(Tampon tampon) {
		this.tampon = tampon;
	}

	@Override
	public void run() {

		while (true) {
			int val = tampon.take();
			System.out.println("Consomateur :take " + val);

		}

	}
}
