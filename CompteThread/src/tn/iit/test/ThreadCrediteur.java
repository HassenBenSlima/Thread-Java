package tn.iit.test;

public class ThreadCrediteur extends Thread {

	private Compte compte;

	public ThreadCrediteur(Compte compte) {
		this.compte = compte;
	}

	public void run() {
		for (int i = 0; i < 10; i++) {
			compte.depot(50);
		}
	}
}
