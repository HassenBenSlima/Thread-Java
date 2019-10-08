package LecteursRedacteurs;

class Redacteur extends Thread {
	LectRed Mo;

	Redacteur(LectRed Mo) {
		this.Mo = Mo;
	}

	public void run() {
		try {
			while (true) {
				Mo.startwrite();
				Mo.ecrire();
				Mo.endwrite();
			}
		} catch (InterruptedException e) {
		}
	}
}