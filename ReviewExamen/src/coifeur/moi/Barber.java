package coifeur.moi;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class Barber extends Thread {

	protected Lock lock;
	protected Condition barberCond;
	protected Condition customerCond;
	protected Condition chairCond;
	protected int nbreChair;
	protected static int nbreChairFree;

	public Barber(Lock lock, Condition barberCond, Condition customerCond, Condition chairCond, int nbreChair) {
		super();
		this.lock = lock;
		this.barberCond = barberCond;
		this.customerCond = customerCond;
		this.chairCond = chairCond;
		this.nbreChair = nbreChair;
		nbreChairFree = nbreChair;
	}

	// barber to customers
	public void barberToClients() {
		lock.lock();
		try {

			while (nbreChairFree == nbreChair) {
				System.out.println("Waiting for customers");
				barberCond.await();
			}
			Customer.notified = true;
			System.out.println("1");
			customerCond.signal();
			System.out.println("3");
			chairCond.await();
			System.out.println("4");

			System.out.println("Begin hair cut");
			sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

	@Override
	public void run() {
		while (true) {
			barberToClients();
		}

	}

}