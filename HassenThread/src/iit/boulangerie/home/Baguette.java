package iit.boulangerie.home;

public class Baguette {

	private static int count;
	private int indice;

	public Baguette() {
		count++;
		indice = count;
	}

	@Override
	public String toString() {
		return "Baguette [" + indice + "]";
	}

}
