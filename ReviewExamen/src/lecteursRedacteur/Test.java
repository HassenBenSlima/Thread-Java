/**
 * 
 */
package lecteursRedacteur;

/**
 * @author azuse
 *
 */
public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LectRed lectRed = new LectRed();

		Thread read = new Redacteur(lectRed);
		Thread write = new Lecteur(lectRed);

		read.start();
		write.start();
	}

}
