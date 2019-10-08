package philosophes.moi;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ChopStick {
	protected int id;
	protected Lock lock = new ReentrantLock();

	public ChopStick(int id) {

		this.id = id;
	}

	public boolean pickUp(Philosopher philosopher, String where) {
		try {
			if (lock.tryLock(10, TimeUnit.MILLISECONDS)) {
				System.out.println(philosopher + " pick up " + where + "Chopstick " + this);
				return true;
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return false;

	}

	public void putDown(Philosopher philosopher, String where) {
		lock.unlock();
		System.out.println(philosopher + " put Down up " + where + "Chopstick :" + this);

	}

	@Override
	public String toString() {
		return "ShopStick [" + id + "]";
	}

}
