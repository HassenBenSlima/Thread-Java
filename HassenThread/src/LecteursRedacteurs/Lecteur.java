package LecteursRedacteurs;

class Lecteur extends Thread {
	LectRed Mo;

	Lecteur(LectRed Mo) {
		this.Mo = Mo;
	}

	public void run() {
		try {
			while (true) {
				Mo.startread();
				Mo.lire();
				Mo.endread();
			}
		} catch (InterruptedException e) {
		}
	}
}