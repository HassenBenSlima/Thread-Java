/**
 * 
 */
package producteurConsommateur;

/**
 * @author azuse
 *
 */
public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Tampon tampon = new Tampon();
		Thread p = new Producteur(tampon);
		Consomateur c = new Consomateur(tampon);
		Thread t1 = new Thread(c);
		t1.start();
		p.start();

	}

}
