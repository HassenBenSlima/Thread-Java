package iit.philosophes;

public class Test {

	public static void main(String[] args) {
		Philosophes p = new Philosophes();
		Thread t1 = new Thread(p);
		t1.start();

	}

}
