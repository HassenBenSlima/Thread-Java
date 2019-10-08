package coifeur2;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

//========================================================================
//BarberLock in Java
//Fabrice Peix --- ESSI --- 2006
//------------------------------------------------------------------------
//Usage:
//javac BarberLock.java
//java BarberLock nbChairs nbCustomers
//========================================================================
/**
 * Simulate Customer behaviors with Lock
 *
 * @author Fabrice Peix
 */
public class CustomerLock extends Thread {
	static boolean notified = false;
	/** Waiting room capacity */
	private int nbChairs;
	/** Le Lock used to protect shared data */
	private Lock l;
	/** Used Condition */
	private Condition customerCond;
	private Condition barberCond;
	private Condition chairCond;

	/**
	 * @param numero
	 * @param l
	 *            The lock
	 * @param customerCond
	 *            Condition used by customer to waait
	 * @param barberCond
	 *            Condition used by barber to wait
	 * @param barberCond
	 *            Condition used by barber to call customer on his chair
	 * @param nbChairs
	 *            Waiting room capacity
	 */
	public CustomerLock(int numero, Lock l, Condition customerCond, Condition barberCond, Condition chairCond,
			int nbChairs) {
		super("Client " + numero);
		this.l = l;
		this.customerCond = customerCond;
		this.barberCond = barberCond;
		this.chairCond = chairCond;
		this.nbChairs = nbChairs;
	}

	/**
	 * Customer go to barber
	 *
	 * @return true if haircut is done and false otherwise
	 */
	private boolean haircut() {
		l.lock();
		try {
			if (BarberLock.nbFreeChairs == 0) {
				System.out.println("Client " + getName() + " drink coffee...");
				return false;
			}
			if (BarberLock.nbFreeChairs == nbChairs) {
				System.out.println("Client " + getName() + " wake up barber");
				barberCond.signal();
			}
			BarberLock.nbFreeChairs--;
			while (!notified) {
				System.out.println("Client " + getName() + " wait for barber");
				customerCond.await();
			}
			notified = false;
			BarberLock.nbFreeChairs++;
			chairCond.signal();
			System.out.println("Client " + getName() + " is on barber chair");
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			l.unlock();

		}
		return true;
	}

	public void run() {
		while (!haircut())
			try {
				sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	}
}
