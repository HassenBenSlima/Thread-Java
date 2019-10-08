package tn.iit.test;

public class CompteModifier implements Runnable {

	private Compte compte;
	private boolean retrait;

	public CompteModifier(Compte compte, boolean retrait) {
		this.compte = compte;
		this.retrait = retrait;
	}

	@Override
	public void run() {

		for (int i = 0; i < 10; i++) {
			if (retrait) {
				compte.retrait(20);
			} else {

				compte.depot(20);
			}
		}
	}

	public static void main(String[] args) {
		Compte compte = new Compte(200);

		Thread th1 = new Thread(new CompteModifier(compte, true));
		Thread th2 = new Thread(new CompteModifier(compte, false));
		th1.start();
		th2.start();

		try {
			th1.join();
			th2.join();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println(compte.getSolde());
	}
}
