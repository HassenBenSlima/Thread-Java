package train;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Train {

	Lock lock;
	int nbreTrainAversB;// Compte le nombre de trains allant de B vers A.
	int nbreTrainBversA;// Compte le nombre de trains allant de B vers A.
	int nbreTrainAttAversB;
	int nreTrainAttBversA;

	Condition cab, cba;

	public Train() {
		lock = new ReentrantLock();
		nbreTrainAversB = 0;
		nbreTrainBversA = 0;
		nbreTrainAttAversB = 0;
		nreTrainAttBversA = 0;
		cab = lock.newCondition();
		cba = lock.newCondition();
	}

	public void Entree_AB() {
		lock.lock();
		try {
			if (nbreTrainBversA > 0) {
				nbreTrainAttAversB++;
				cab.await();
			}
			nbreTrainAversB++;
			if (nbreTrainAttAversB > 0) {
				nbreTrainAttAversB--;
				cab.signal();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			System.out.println("EntreeA");
			lock.unlock();
		}
	}

	public void Sortie_AB() {
		lock.lock();
		try {
			nbreTrainAversB--;
			if (nbreTrainAversB == 0) {
				if (nreTrainAttBversA > 0) {
					nreTrainAttBversA--;
					cba.signal();
				}
			}
		} finally {
			System.out.println("SortieB");

			lock.unlock();
		}
	}

	public void Entree_BA() {
		lock.lock();
		try {
			if (nbreTrainAversB > 0) {
				nreTrainAttBversA++;
				cba.await();
			}
			nbreTrainBversA++;
			if (nreTrainAttBversA > 0) {
				nreTrainAttBversA--;
				cba.signal();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			System.out.println("EntreeB");

			lock.unlock();
		}
	}

	public void Sortie_BA() {
		lock.lock();
		try {
			nbreTrainBversA--;
			if (nbreTrainBversA == 0) {
				if (nbreTrainAttAversB > 0) {
					nbreTrainAttAversB--;
					cab.signal();
				}
			}
		} finally {
			System.out.println("Sortie_A");
			lock.unlock();
		}
	}

}
