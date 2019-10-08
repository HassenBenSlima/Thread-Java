package tp1.ex1;

public class Baguette {

	private int num;
	private static int compter = 0;

	public Baguette() {
		compter++;
		num = compter;
	}

	public int getNum() {
		return num;
	}

	@Override
	public String toString() {
		return "Baguette [num=" + num + "]";
	}

}
