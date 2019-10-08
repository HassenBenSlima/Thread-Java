package journalite;

import java.util.Scanner;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class Journaliste extends Thread {
	private String nom;
	private Lock verrou;
	private Condition question;
	private Condition reponse;
	private Scanner sc = new Scanner(System.in);

	public Journaliste(String pNom, Lock pVerrou, Condition pQuestion, Condition pReponse) {
		nom = pNom;
		verrou = pVerrou;
		question = pQuestion;
		reponse = pReponse;
	}

	public void question() {
		verrou.lock();
		try {
			System.out.println(nom + ", posez votre question : ");
			sc.nextLine();
			// On libère le thread de réponse
			reponse.signalAll();
			// On bloque ce thread
			question.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			// On n’oublie pas de libérer le verrou !
			verrou.unlock();
		}
	}

	public void run() {
		while (true) {
			question();
		}
	}
}