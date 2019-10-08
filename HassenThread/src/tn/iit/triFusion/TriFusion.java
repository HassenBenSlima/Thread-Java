package tn.iit.triFusion;

public class TriFusion extends Thread {
	int[] t;
	int i, n;

	public TriFusion(int[] t, int i, int n) {
		this.t = t;
		this.i = i;
		this.n = n;
	}

	 public void remplirTable(int i, int n, int[] t) {
	 int rand;
	 for (int k = i; k < n; k++) {
	 rand = (int) Math.random();
	 t[k] = rand;
	 }
	 }

	void tricroissant(int a[], int m, int b) {
		int x;
		for (int i = m; i < b; i++) {
			for (int j = m; j < b; j++) {
				if (a[i] < a[j]) {
					x = a[i];
					a[i] = a[j];
					a[j] = x;
				}

			}

		}
	}

	public static void affichage(int t[], int n) {
		for (int i = 0; i < n; i++) {
			System.out.print(t[i] + " ");
		}
	}

	public static void trifusion(int a[], int nouveauTable[]) {
		int k = 0;
		int i = 0;
		int j = ((a.length + 1) / 2);
		while (i < (a.length + 1) / 2 && (j < a.length)) {
			if (a[i] < a[j]) {
				nouveauTable[k++] = a[i];
				i++;
			}
			if (a[i] > a[j]) {
				nouveauTable[k++] = a[j];
				j++;
			}
		}

		// copier les elements restant de la premiere moitié
		if (i < (a.length + 1) / 2) {
			for (int h = k; h < nouveauTable.length; h++) {
				nouveauTable[k] = a[i];
				k++;
				i++;
			}
		}
		// copier les elements restant de la deuxieme moitié
		if (j < a.length) {
			for (int h = k; h < nouveauTable.length; h++) {
				nouveauTable[k] = a[j];
				k++;
				j++;
			}
		}

	}

	@Override
	public void run() {
		tricroissant(t, i, n);
	}

	public static void main(String[] args) {
		int t[] = { 1, 10, 2, 4, 7, 5, 9, 8 };
		int[] nouveauTable = new int[8];

		Thread t1 = new Thread(new TriFusion(t, 0, (t.length + 1) / 2));
		Thread t2 = new Thread(new TriFusion(t, ((t.length + 1) / 2), t.length));
		t1.start();
		try {
			t1.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		t2.start();
		try {
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		TriFusion.affichage(t, t.length);

		Thread t3 = new Thread(new Runnable() {

			@Override
			public void run() {
				TriFusion.trifusion(t, nouveauTable);

			}
		});
		t3.start();
		try {
			t3.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println();
		TriFusion.affichage(nouveauTable, nouveauTable.length);
	}

}
