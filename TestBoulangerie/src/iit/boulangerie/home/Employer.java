package iit.boulangerie.home;

public class Employer implements Runnable {

	public Employer() {
	}

	@Override
	public void run() {
		System.out.println("*******************************");
		System.out.println("Farine");
		System.out.println("*******************************");
	}

}
