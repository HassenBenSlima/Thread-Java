package lecteursRedacteur;

public class Lecteur extends Thread {
	LectRed lectRed;

	public Lecteur(LectRed lr) {
		this.lectRed = lr;
	}

	@Override
	public void run() {
		while (true) {
			lectRed.startRead();
			lectRed.read();
			lectRed.endRead();

		}

	}
}
