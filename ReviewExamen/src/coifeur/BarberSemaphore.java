package coifeur;

import java.util.concurrent.Semaphore;

// ========================================================================
// BarberSemaphore in Java
// Fabrice Peix --- ESSI --- 2006
// ------------------------------------------------------------------------
// Usage:
// javac BarberSemaphore.java
// java BarberSemaphore nbChairs nbCustomers
// ========================================================================
/**
 * Simulate barber behaviors with Semaphore.
 *
 * @author Fabrice Peix
 */
public class BarberSemaphore extends Thread {
	/** Semaphores */
	private Semaphore busyChairsC, barberChairC;

	public BarberSemaphore(Semaphore busyChairs, Semaphore barberChair) {
		this.busyChairsC = busyChairs;
		this.barberChairC = barberChair;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Runnable#run()
	 */
	public void run() {
		while (true) {
			try {
				System.out.println("waiting for customer ...");
				busyChairsC.acquire();
				System.out.println("Customer arrive ! go to work...");
				barberChairC.release();
				Thread.sleep(1000);
			} catch (Exception e) {
				System.out.println("haircut interrupted");
			}
			System.out.println("Haircut is over");
		}
	}

	/**
	 * Simulate custumer behaviors with Semaphore.
	 *
	 * @author Fabrice Peix
	 */
	public class CustomerSemaphore extends Thread {
		private Semaphore freeChairs_, busyChairs_, barberChair_;

		public CustomerSemaphore(String name, Semaphore freeChairs, Semaphore busyChairs, Semaphore barberChair) {
			super(name);
			this.freeChairs_ = freeChairs;
			this.busyChairs_ = busyChairs;
			this.barberChair_ = barberChair;
		}

		/*
		 * (non-Javadoc)
		 *
		 * @see java.lang.Runnable#run()
		 */
		public void run() {
			try {
				while (!freeChairs_.tryAcquire())
					// Try to take a place in barbershop
					sleep(5000); // Go to pub drink a cup of coffee
				System.out.println(getName() + " Cool ! get a place");
				busyChairs_.release();
				System.out.println(getName() + "Waiting for barber...");
				barberChair_.acquire();
				freeChairs_.release();
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println(getName() + "Interrupted during haircut");
			}
		}
	}

	public static void main(String[] args) {
		// read command-line arguments
		if (args.length != 2) {
			System.err.println("usage: BarberSemaphore nbChairs nbCustomers");
			System.exit(1);
		}
		int nbChairs = 5;
		int nbCustomers = 6;
		System.err.println("Starting BarberSemaphore with " + nbChairs + " chairs and " + nbCustomers + " customers");
		// Initialize Semaphore
		Semaphore freeChairs = new Semaphore(nbChairs);
		Semaphore busyChairs = new Semaphore(0);
		Semaphore barberChair = new Semaphore(0);
		// Create barber thread
		BarberSemaphore c = new BarberSemaphore(busyChairs, barberChair);
		c.start();
		// Create customers threads
		for (int i = 0; i < nbCustomers; i++) {

			CustomerSemaphore customer = c.new CustomerSemaphore("Client " + i + ":", freeChairs, busyChairs,
					barberChair);
			customer.start();
		}
	}
}