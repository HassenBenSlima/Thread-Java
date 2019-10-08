package iit.rectCondition.PC;

public class Test {

	public static void main(String[] args) {
		Tampon tampon = new Tampon();
		Thread p = new Producteur(tampon);
		Thread c = new Consomateur(tampon);

		p.start();
		c.start();

	}

}
