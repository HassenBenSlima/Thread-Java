package iit.rectCondition.PC;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Tampon {

	ReentrantLock lock = new ReentrantLock();
	private int[] tab;
	int indice;
	Condition empty = lock.newCondition();
	Condition full = lock.newCondition();

	public Tampon() {
		tab = new int[10];
		indice = 0;
	}

	public int take() {
		int temp = 0;
		try {
			lock.lock();
			if (indice == 0) {

				empty.await();

			}

			temp = tab[indice - 1];
			tab[indice - 1] = -1;
			System.out.println("indice :" + indice + " tab: " + tab[indice - 1] + " temp: " + temp);

			indice--;
			full.signal();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
		return temp;
	}

	public void put(int val) {
		try {
			lock.lock();
			if (indice == 10) {
				full.await();

			}

			tab[indice] = val;
			indice++;
			empty.signal();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

}
