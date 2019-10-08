package train;

public class Test {
	public static void main(String[] args) {

		Train tr = new Train();
		Thread t1 = new Thread(() -> {
			while (true) {
				tr.Entree_AB();
				tr.Sortie_AB();
				tr.Entree_BA();
				tr.Sortie_BA();
			}
		});

		t1.start();
	}

}
