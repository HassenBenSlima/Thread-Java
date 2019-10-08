package journalite;

import java.util.Scanner;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class Personne extends Thread {

	private String nom;
	private Lock verrou;
	private Condition question;
	private Condition reponse;
	private Scanner sc = new Scanner(System.in);

	public Personne(String pNom, Lock pVerrou, Condition pQuestion, Condition pReponse) {
		nom = pNom;
		verrou = pVerrou;
		question = pQuestion;
		reponse = pReponse;
	}

	public void reponse() {

		try {
			verrou.lock();
			System.out.println(nom + ", votre réponse ?");
			sc.nextLine();
			// On informe redemande une question
			question.signalAll();
			// On bloque la réponse
			reponse.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			// et on libère le verrou !
			verrou.unlock();
		}
	}

	public void run() {
		while (true) {
			reponse();
		}
	}
}