package philosophe;

import java.util.concurrent.Semaphore;

public class Fork {

	private boolean inuse;
	Semaphore sem;

	public Fork() {

		inuse = false;
		sem = new Semaphore(1);
	}

	public void getFork() {
		try {
			while (inuse) {
				try {
					sem.acquire();
				} catch (Exception e) {
				}
			}
			inuse = true;
		} catch (Exception e) {
		}
	}

	public void putFork() {
		try {
			inuse = false;
			sem.release();
		} catch (Exception e) {
		}
	}

	public boolean isUsed() {
		return inuse;
	}
}