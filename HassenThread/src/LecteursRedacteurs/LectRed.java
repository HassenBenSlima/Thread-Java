package LecteursRedacteurs;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LectRed {
	final Lock lock = new ReentrantLock();
	final Condition oktoread;
	final Condition oktowrite;
	int readers; // nb de lecteurs actifs
	int writeAtt; // nb de rédacteurs en attente
	int readAtt;// nb lecteurs en attente
	boolean writing;

	LectRed() {
		oktoread = lock.newCondition();
		oktowrite = lock.newCondition();
		readers = 0;
		writeAtt = 0;
		readAtt = 0;
		writing = false;
	}

	void startread() throws InterruptedException {
		lock.lock();
		try {
			readAtt++;
			if (writing || writeAtt > 0) {
				oktoread.await();
			}
			readAtt--;
			readers = readers + 1;
			//oktoread.signal();
		} finally {
			lock.unlock();
		}
	}

	void endread() throws InterruptedException {
		lock.lock();
		try {
			readers = readers - 1;
			if (readers == 0)
				oktowrite.signal();
		} finally {
			lock.unlock();
		}
	}

	void startwrite() throws InterruptedException {
		lock.lock();
		try {
			writeAtt++;
			if (readers != 0 || writing)
				oktowrite.await();
			writeAtt--;
			writing = true;
		} finally {
			lock.unlock();
		}
	}

	void endwrite() throws InterruptedException {
		lock.lock();
		try {
			writing = false;
			if (readAtt > 0)
				oktoread.signal();
			else
				oktowrite.signal();

		} finally {
			lock.unlock();
		}
	}

	void lire() {
		lock.lock();
		try {
			System.out.println("je suis entrain de lire de la base");
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

	void ecrire() {
		lock.lock();
		try {
			System.out.println("je suis entrain d’ecrire sur la base");
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}
}