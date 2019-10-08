/**
 * 
 */
package coifeur.moi;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Hassen Hssouna
 *
 */
public class Test {

	/**
	 * @param Hassen Hssouna
	 */
	public static void main(String[] args) {
		int nbChairs = 6;
		int nbCustomers = 7;
		System.out.println("Starting BarberSemaphore with " + nbChairs + " chairs and " + nbCustomers + " customers");

		Lock lock = new ReentrantLock();
		Condition barberCond = lock.newCondition();
		Condition customerCond = lock.newCondition();
		Condition chairCond = lock.newCondition();

		Barber barber = new Barber(lock, barberCond, customerCond, chairCond, nbChairs);
		barber.start();

		for (int i = 0; i < nbCustomers; i++) {
			new Customer(i, lock, barberCond, customerCond, chairCond, nbChairs).start();
		}

	}

}
