package tn.iit.test;

public class ThreadDebiter extends Thread {

	private Compte compte;

	public ThreadDebiter(Compte compte) {
		this.compte = compte;
	}

	public void run() {
		for (int i = 0; i < 10; i++) {
			compte.retrait(50);
		}
	}
}
