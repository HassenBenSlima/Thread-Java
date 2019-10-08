package producteurConsommateur;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Tampon {

	private int[] tab;
	private int indice;

	private final int limit = 10;
	private Lock lock = new ReentrantLock();
	private Condition oktoProduct = lock.newCondition();
	private Condition oktoConcume = lock.newCondition();

	public Tampon() {
		this.tab = new int[limit];
		this.indice = 0;
	}

	// produce
	public void put(int val) {

		try {
			lock.lock();

			if (indice == limit) {
				oktoProduct.await();
			}

			tab[indice] = val;
			indice++;
			oktoConcume.signal();
			System.out.println("coucou");

		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	// consume
	public int take() {
		int temp = 0;
		try {
			lock.lock();

			if (indice == 0) {
				System.out.println("befor await");

				oktoConcume.await();
				System.out.println("after await");

			}
			temp = tab[indice - 1];

			tab[indice - 1] = -1;
			System.out.println("indice :" + indice + " tab: " + tab[indice - 1] + " temp: " + temp);

			indice--;
			System.out.println("BEFOR SIGNAL");

			oktoProduct.signal();
			System.out.println("AFTER SIGNAL");

		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return temp;
	}

}
