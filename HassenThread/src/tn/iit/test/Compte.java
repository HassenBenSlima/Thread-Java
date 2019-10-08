package tn.iit.test;

public class Compte {
	private double solde;

	public Compte(double solde) {
		this.solde = solde;
	}

	synchronized public void depot(double montant) {
		this.solde += montant;
	}

	synchronized public void retrait(double montant) {
		if (this.solde >= montant) {
			this.solde -= montant;
		} else {
			throw new RuntimeException("Solde insuffisant");
		}
	}

	public double getSolde() {
		return solde;
	}

	public void setSolde(double solde) {
		this.solde = solde;
	}

}
