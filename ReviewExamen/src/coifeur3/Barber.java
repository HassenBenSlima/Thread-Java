package coifeur3;

import java.util.Vector;

//========================================================================
//BarberMonitor in Java
//Fabrice Peix --- ESSI --- 2006
//------------------------------------------------------------------------
//Usage:
//javac BarberMonitor.java
//java BarberMonitor nbChairs nbCustomers
//========================================================================
/**
 * Simulate the behaviors of barber in Monitor case.
 *
 * @author Fabrice Peix
 */
public class Barber extends Thread {
	/** the shop the barber works at */
	private BarberMonitor shop;
	/** Time of one cut */
	private final int cutTime = 2000;

	/**
	 * Create a barber in a given shop. 1 c’est-à-dire avec des méthodes
	 * synchronisées et l’utilisation des primitives wait() et notify()/notifyAll()
	 * 4
	 *
	 * @param shop
	 *            The shop in which the barber is created
	 */
	Barber(BarberMonitor shop) {
		super("barber");
		this.shop = shop;
	}

	/**
	 * Method simulating hair cuting.
	 */
	private void hairCut() {
		System.out.println("Barber cutting");
		try {
			sleep(cutTime);
		} catch (Exception e) {
		}
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Runnable#run()
	 */
	public void run() {
		System.out.println("Barber at work ");
		while (true) {
			try {
				shop.getCustomer();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			hairCut();
			shop.showCustomerOut();
		}
	}
}

/**
 * Simmulate Customer behavior.
 *
 * @author Fabrice Peix
 */
class Customer extends Thread {
	/** Id of this customer */
	private int cust;
	/** The barber shop */
	private BarberMonitor shop;

	/**
	 * Initialize a new customer. 5
	 *
	 * @param cust
	 *            the id of this new customer.
	 * @param shop
	 *            the baber shop
	 */
	Customer(int cust, BarberMonitor shop) {
		super("customer " + cust);
		this.cust = cust;
		this.shop = shop;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Runnable#run()
	 */
	public void run() {
		System.out.println("Customer " + cust + " starting");
		try {
			while (!shop.goToHairDresser()) {
				System.out.println("Customer " + cust + " still needs an hair cut");
				sleep(3000);
			}
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
	}
}

/**
 * Simulate the barbershop behaviors. All concurrent access are managed in this
 * class.
 */
class BarberMonitor {
	/** Number of chairs in waiting room */
	int nbChairs;
	/** FIFO of customer present in the room */
	private Vector<Thread> customer = new Vector<Thread>();

	public BarberMonitor(int nbChairs) {
		this.nbChairs = nbChairs;
	}

	/**
	 * Try to go to the barbershop.
	 *
	 * @return true if customer make an haircut and false otherwise.
	 */
	public boolean goToHairDresser() throws InterruptedException {
		Customer current = (Customer) Thread.currentThread();

		synchronized (current) {
			synchronized (this) {
				if (customer.size() == nbChairs)
					return false;
				System.out.println(Thread.currentThread().getName() + " waiting");
				if (customer.size() == 0)
					notify();
				customer.add(current);
			}
			current.wait();
		}
		return true;
	}

	/** Save the last customer, used to print his name in ShowCustomerOut */
	private Thread lastCustomer;

	/**
	 * Make an haircut or wait for customers.
	 */
	public void getCustomer() throws InterruptedException {
		// wait for customer
		synchronized (this) {
			System.out.println("Barber waiting for customer");
			while (customer.size() == 0)
				wait();
			lastCustomer = customer.remove(0);
			synchronized (lastCustomer) {
				lastCustomer.notify();
			}
		}
	}

	/**
	 * Write to stdout the name of the last customer.
	 *
	 */
	public synchronized void showCustomerOut() {
		System.out.println("Customer " + lastCustomer.getName() + " is out");
	}

	static public void main(String[] args) {
		try {

			int nbChairs = 10;
			int nbCustomers = 11;
			System.out
					.println("Starting BarberSemaphore with " + nbChairs + " chairs and " + nbCustomers + " customers");

			// create shop
			BarberMonitor shop = new BarberMonitor(nbChairs);
			// create barber
			new Barber(shop).start();
			// create customers
			for (int i = 0; i < nbCustomers; ++i) {
				new Customer(i, shop).start();
			}
		} catch (Exception e) { // report any exceptions
			System.err.println("Exception in BarberShop.main" + e);
		}
	}
}
