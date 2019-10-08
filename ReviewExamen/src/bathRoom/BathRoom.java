package bathRoom;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BathRoom {
	private Lock lock = new ReentrantLock();
	private Condition womenWaitingQueue = lock.newCondition();
	private Condition menWaitingQueue = lock.newCondition();

	private int womenWaitingN = 0;
	private int menWaitingN = 0;
	private int womenUsingN = 0;
	private int menUsingN = 0;
	private int numberOfToilets;
	private int occupiedCount;

	public BathRoom(int numberOfToilets, int occupiedCount) {
		this.numberOfToilets = numberOfToilets;
		this.occupiedCount = occupiedCount;
	}

	public void woman_wants_to_enter(int i) throws InterruptedException {

		lock.lock();
		try {

			if (occupiedCount < numberOfToilets) {

				if (menUsingN == 0) {

					if (womenWaitingN == 0) {
						System.out.println("Woman " + i + " enters bathroom ");
						womenUsingN++;
						occupiedCount++;
					} else {
						while (womenWaitingN != 0) {
							System.out.println("Woman " + i + " in waiting------------>>>>");
							womenWaitingN++;
							womenWaitingQueue.await();
						}
					}
				} else {
					while (menUsingN != 0) {
						System.out.println("Woman " + i + " in waiting------------>>>>");
						womenWaitingN++;
						womenWaitingQueue.await();
					}
				}

			} else {
				while (occupiedCount == numberOfToilets) {
					System.out.println("Woman " + i + " in waiting------------>>>>");
					womenWaitingN++;
					womenWaitingQueue.await();
				}
			}

		} finally {
			lock.unlock();
		}
	}

	public void woman_leaves(int i) throws InterruptedException {

		lock.lock();
		try {

			womenUsingN--;
			occupiedCount--;
			System.out.println("Woman " + i + " exits bathroom ");

			if (womenWaitingN > 0) {
				womenWaitingQueue.signal();
				womenUsingN++;
				occupiedCount++;
				womenWaitingN--;
			} else if (menWaitingN > 0 && womenUsingN == 0) {
				menWaitingQueue.signal();
				menUsingN++;
				occupiedCount++;
				menWaitingN--;
			}

		} finally {
			lock.unlock();
		}

	}

	public void man_wants_to_enter(int i) throws InterruptedException {
		lock.lock();
		try {

			if (occupiedCount < numberOfToilets) {

				if (womenUsingN == 0) {

					if (womenWaitingN > 0) {
						womenWaitingQueue.signal();
						womenUsingN++;
						occupiedCount++;
						womenWaitingN--;
					} else {
						menUsingN++;
						occupiedCount++;
						System.out.println("Man " + i + " enters bathroom ");
						menWaitingQueue.signal();
					}
				} else {
					while (womenUsingN != 0) {
						System.out.println("Man " + i + " in waiting------------>>>>");
						menWaitingN++;
						menWaitingQueue.await();
					}
				}

			} else {
				while (occupiedCount == numberOfToilets) {
					System.out.println("Man " + i + " in waiting------------>>>>");
					menWaitingN++;
					menWaitingQueue.await();
				}
			}

		} finally {
			lock.unlock();
		}
	}

	public void man_leaves(int i) throws InterruptedException {
		lock.lock();
		try {

			menUsingN--;
			occupiedCount--;
			System.out.println("Man " + i + " exits bathroom ");

			if (womenWaitingN > 0 && menUsingN == 0) {
				womenWaitingQueue.signal();
				womenUsingN++;
				occupiedCount++;
				womenWaitingN--;
			} else if (menWaitingN > 0) {
				menWaitingQueue.signal();
				menWaitingN--;
				menUsingN++;
				occupiedCount++;
			}
		} finally {
			lock.unlock();
		}
	}
}