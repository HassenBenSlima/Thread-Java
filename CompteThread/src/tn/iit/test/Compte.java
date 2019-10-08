package tn.iit.test;

public class Compte {
	
	private double solde;
	
	public Compte(double solde) {
		this.solde = solde;

	}

	public void depot(double montant) {
		synchronized (this) {

			this.solde += montant;
			// System.out.println("solde after credit "+solde);
		}
		/*
		 * double temp = solde + montant; // Thread.yield(); try {
		 * Thread.currentThread().sleep(1); } catch (InterruptedException e) {
		 * e.printStackTrace(); } solde = temp;
		 */

	}

	public void retrait(double montant) throws SoldeInsuffisantException{
		synchronized (this) {
			if (this.solde >= montant) {

				this.solde -= montant;

				// System.out.println("solde after debit "+solde);
			} else {
				throw new SoldeInsuffisantException("Solde insuffisant");
			}
		}
	}

	public double getSolde() {
		return solde;
	}

	public void setSolde(double solde) {
		this.solde = solde;
	}

	public void consulter() {
		System.out.println("Votre credit: " + solde);
	}

}
