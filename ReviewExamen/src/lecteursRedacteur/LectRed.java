package lecteursRedacteur;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LectRed {
	Lock lock;
	Condition okToWrite;
	Condition okToRead;
	int nbreReaderActive;
	int nbreWriterAtt;
	int nbreReaderAtt;
	boolean writing;

	public LectRed() {
		lock = new ReentrantLock();
		okToWrite = lock.newCondition();
		okToRead = lock.newCondition();
		nbreReaderActive = 0;
		nbreReaderAtt = 0;
		nbreWriterAtt = 0;
		writing = false;
	}

	public void startRead() {
		lock.lock();
		try {

			nbreReaderAtt++;
			if (writing || nbreWriterAtt > 0) {
				okToRead.await();
			}
			nbreReaderAtt--;
			nbreReaderActive++;
			okToRead.signal();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

	public void endRead() {
		lock.lock();
		try {

			nbreReaderActive--;
			if (nbreReaderActive == 0) {
				okToWrite.signal();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

	public void startWrite() {
		lock.lock();
		try {
			nbreWriterAtt++;
			if (nbreReaderActive != 0 || writing) {
				okToWrite.await();
			}
			nbreWriterAtt--;
			writing = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

	public void endWrite() {
		lock.lock();
		try {
			writing = false;
			if (nbreReaderAtt > 0) {
				okToRead.signal();
			} else {
				okToWrite.signal();
			}
		} finally {
			lock.unlock();
		}
	}

	public void read() {
		System.out.println("je suis entrain de lire la base");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void write() {
		System.out.println("je suis entrain d'ecrire sur la base");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
