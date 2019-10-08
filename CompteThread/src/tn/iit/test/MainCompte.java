package tn.iit.test;

public class MainCompte {

	public static void main(String[] args) {

		Compte compte = new Compte(1000);
		Thread crediter = new ThreadCrediteur(compte);
		Thread debiter = new ThreadDebiter(compte);

		crediter.start();
		debiter.start();
		try {
			crediter.join();
			debiter.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		compte.consulter();

	}

}
