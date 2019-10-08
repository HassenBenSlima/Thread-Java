package coifeur2;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Simulate barber behavior with Lock
 *
 * @author Fabrice Peix
 */
public class BarberLock extends Thread {
	/** waiting room capacity */
	private int nbChairs;
	/** free chairs in barber waiting room */
	public static int nbFreeChairs;
	/** The Lock */
	private Lock lock;
	/** Various Condition */
	private Condition customerCond;
	private Condition barberCond;
	private Condition chairCond;

	/**
	 * Initialize barber
	 *
	 * @param l
	 *            The lock
	 * @param customerCond
	 *            Condition used by customer to wait
	 * @param barberCond
	 *            Condition used by barber to wait
	 * @param barberCond
	 *            Condition used by barber to call customer on his chair
	 * @param nbChairs
	 *            Waiting room capacity
	 */
	public BarberLock(Lock l, Condition customerCond, Condition barberCond, Condition chairCond, int nbChairs) {
		super();
		this.lock = l;
		this.customerCond = customerCond;
		this.barberCond = barberCond;
		this.chairCond = chairCond;

		this.nbChairs = nbChairs;
		nbFreeChairs = nbChairs;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Runnable#run()
	 */
	public void run() {
		while (true) {
			lock.lock();
			try {
				while (nbFreeChairs == nbChairs) {
					System.out.println("Waiting for customers");
					barberCond.await();
				}
				CustomerLock.notified = true;
				customerCond.signal();
				chairCond.await();
				System.out.println("Begin hair cut");
				sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				lock.unlock();
			}
		}
	}

	public static void main(String args[]) {

		int nbChairs = 6;// Integer.parseInt(args[0]);
		int nbCustomers = 7;// Integer.parseInt(args[1]);
		System.out.println("Starting BarberSemaphore with " + nbChairs + " chairs and " + nbCustomers + " customers");
		// Create Lock and Condition
		Lock realLock = new ReentrantLock();
		Condition customerCond = realLock.newCondition();
		Condition barberCond = realLock.newCondition();
		Condition chairCond = realLock.newCondition();
		// Create barber thread
		BarberLock barber = new BarberLock(realLock, customerCond, barberCond, chairCond, nbChairs);
		barber.start();

		// Create customers threads
		for (int i = 0; i < nbCustomers; i++) {
			new CustomerLock(i, realLock, customerCond, barberCond, chairCond, nbChairs).start();
		}
	}
}
