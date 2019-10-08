package coifeur.moi;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class Customer extends Thread {

	protected Lock lock;
	protected Condition barberCond;
	protected Condition customerCond;
	protected Condition chairCond;
	protected static boolean notified = false;
	protected int nbreChair;

	public Customer(int numero, Lock lock, Condition barberCond, Condition customerCond, Condition chairCond,
			int nbreChair) {
		super("Client " + numero);
		this.lock = lock;
		this.barberCond = barberCond;
		this.customerCond = customerCond;
		this.chairCond = chairCond;
		this.nbreChair = nbreChair;
	}

	public boolean haircut() {
		lock.lock();
		try {
			if (Barber.nbreChairFree == 0) {
				System.out.println(getName() + " drink coffee...");
				return false;
			}

			if (Barber.nbreChairFree == nbreChair) {
				System.out.println(getName() + " wake up barber");
				barberCond.signal();
			}
			Barber.nbreChairFree--;
			while (!notified) {
				System.out.println(getName() + " wait for barber");

				customerCond.await();
								
			}
			System.out.println("2");
			notified = false;
			Barber.nbreChairFree++;
			
			chairCond.signal();
			
			System.out.println(getName() + " is on barber chair");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}

		return true;
	}

	@Override
	public void run() {

		while (!haircut()) {
			try {
				sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}