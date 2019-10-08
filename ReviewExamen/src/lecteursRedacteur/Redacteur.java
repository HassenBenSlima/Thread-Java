package lecteursRedacteur;

public class Redacteur extends Thread {

	LectRed lectRed;

	public Redacteur(LectRed lr) {
		this.lectRed = lr;
	}

	@Override
	public void run() {
		while (true) {
			lectRed.startWrite();
			lectRed.write();
			lectRed.endWrite();
		}
	}

}
