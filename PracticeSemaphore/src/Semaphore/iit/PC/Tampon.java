package Semaphore.iit.PC;

import java.util.concurrent.Semaphore;

public class Tampon {
	// protected int positionTampon;
	protected Semaphore mutex;
	protected Semaphore sPlein;
	protected Semaphore sVide;
	protected int[] tab;
	protected int queue, tete;// tab= [queue--------tete] ; on va utilisé FIFO
	protected int taille;

	public Tampon(int taille) {
		tab = new int[taille];
		sPlein = new Semaphore(0, true);
		sVide = new Semaphore(taille, true);
		mutex = new Semaphore(1, true);
		tete = 0;
		queue = 0;

	}

	// Fifo---Take pour la consommation
	public int take() {
		int val = tab[queue];
		tab[queue] = 0;// 0->Vide
		queue = (1 + queue) % tab.length;
		return val;
	}

	// Fifo--Append pour la production
	public void append(int val) {
		tab[tete] = val;// 0->Vide
		tete = (1 + tete) % tab.length;
	}

	public void consume() throws InterruptedException {
		sPlein.acquire();
		mutex.acquire();
		take();
		System.out.println("C");
		mutex.release();
		sVide.release();

		Thread.sleep(200);

	}

	public void produce() throws InterruptedException {
		sVide.acquire(); // decrimentation
		mutex.acquire();
		int val = (int) Math.random();
		append(val);
		System.out.println("P");
		mutex.release();
		sPlein.release();// incrimentation

		Thread.sleep(200);

	}

}
