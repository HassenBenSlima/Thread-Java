package iit.philosophes;

import java.util.concurrent.Semaphore;

public class Philosophes implements Runnable {

	String[] etat;
	String[] etatPhilosophe;
	Semaphore sphilo;
	Semaphore smutex;
	final int nbrePhilosophes = 5;
	Semaphore stabel;
	int i = 0;

	public Philosophes() {
		smutex = new Semaphore(1, true);
		sphilo = new Semaphore(0, true);
		stabel = new Semaphore(nbrePhilosophes - 1, true);
		etatPhilosophe = new String[] { "pense", "pense", "pense", "pense", "pense" };
		etat = new String[] { "pense", "attend", "mange" };
	}

	public void afficheTable() {

		for (String s : etatPhilosophe) {
			System.out.print(s + " : ");
		}
		System.out.println();

	}

	public void manger(int i) {

		if (etatPhilosophe[(i - 1 + nbrePhilosophes) % nbrePhilosophes] != etat[2]
				&& etatPhilosophe[(i + 1) % nbrePhilosophes] != etat[2] && etatPhilosophe[i] == etat[1]) {
			etatPhilosophe[i] = etat[2];

		}
	}

	public void prendFourchette() {
		try {
			stabel.acquire();
			smutex.acquire();
			etatPhilosophe[i] = etat[1];
			manger(i);
			smutex.release();

			sphilo.release();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {

		}
		try {
			Thread.sleep(300);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void poseFourchette() {
		try {
			sphilo.acquire();
			smutex.acquire();
			etatPhilosophe[i] = etat[0];

			int a = (i - 1 + nbrePhilosophes) % nbrePhilosophes;
			System.out.println(a);
			etatPhilosophe[a] = etat[1];
			manger(a);

			int b = (i + 1) % nbrePhilosophes;
			System.out.println(b);
			etatPhilosophe[b] = etat[1];
			manger(b);

			afficheTable();
			etatPhilosophe[a] = etat[0];
			etatPhilosophe[b] = etat[0];
			i = (i + 1) % nbrePhilosophes;

			smutex.release();
			stabel.release();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {

		}

		try {
			Thread.sleep(300);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {

		while (true) {

			prendFourchette();
			poseFourchette();

		}

	}

}
