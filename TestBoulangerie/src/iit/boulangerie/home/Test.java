/**
 * 
 */
package iit.boulangerie.home;

import java.util.concurrent.CyclicBarrier;

/**
 * @author Hssouna_Hassen
 *
 */
public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Employer e = new Employer();
		CyclicBarrier cyclicBarrier = new CyclicBarrier(2, e);
		Panier panier = new Panier();
		Vendeur vendeur = new Vendeur(panier);
		Boulanger boulanger1 = new Boulanger(panier, cyclicBarrier);
		Boulanger boulanger2 = new Boulanger(panier, cyclicBarrier);
		Boulanger boulanger3 = new Boulanger(panier, cyclicBarrier);
		Boulanger boulanger4 = new Boulanger(panier, cyclicBarrier);

		Thread b1 = new Thread(boulanger1);
		Thread b2 = new Thread(boulanger2);
		Thread b3 = new Thread(boulanger3);
		Thread b4 = new Thread(boulanger4);

		Thread v1 = new Thread(vendeur);
		Thread v2 = new Thread(vendeur);
		Thread v3 = new Thread(vendeur);

		b1.start();
		b2.start();
		b3.start();
		b4.start();

		v1.start();
		v2.start();
		v3.start();

	}

}
