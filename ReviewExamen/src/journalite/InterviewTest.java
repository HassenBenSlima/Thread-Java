package journalite;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class InterviewTest {
	public static void main(String[] main) {
		Lock lock = new ReentrantLock();
		Condition question = lock.newCondition();
		Condition reponse = lock.newCondition();
		Journaliste j = new Journaliste("Amina O5ty", lock, question, reponse);
		Personne p = new Personne("Mohamed 5ouya", lock, question, reponse);

		j.start();
		p.start();
	}
}