package pizzapizza2;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

// Study group class
public class StudyGroup {

	int S = 5;
	int slices = 0; // No. of pizza slices

	private final Lock mutex = new ReentrantLock(); // Lock to ensure one Student can take a slice at a time
	private final Condition orderPizza = mutex.newCondition(); // Condition to order pizza
	private final Condition deliverPizza = mutex.newCondition(); // Condition to deliver pizza

	private boolean firstToSee = true; // First student to see group is out of pizza

	void beginStudying() throws InterruptedException {
		mutex.lock();
		if (slices > 0) {
			--slices; // Decrease no. of slices. Student picks up a slice of pizza.
			// Student takes a slice and starts studying
			System.out.println("Student " + Thread.currentThread().getId() + " took a slice of pizza and is studying");
		} else {
			if (firstToSee) {
				// First student to see that the group is out of pizza
				System.out.println(
						"Group out of pizza. Student " + Thread.currentThread().getId() + " calls Kamal's Pizza");
				orderPizza.signal(); // Call Kamal's Pizza and wake up delivery thread
				firstToSee = false;
			}
			System.out.println("Student " + Thread.currentThread().getId() + " sleeps");
			deliverPizza.await(); // Student sleeps till pizza is delivered
		}
		mutex.unlock();

	}

	void checkOrder() throws InterruptedException {
		mutex.lock();
		slices = S; // Fill plate with new pizza
		System.out.println("Pizza delivered");
		firstToSee = true;
		System.out.println("Wake up sleeping students\n");
		deliverPizza.signalAll(); // Wake up all sleeping Students
		orderPizza.await(); // PizzaDelivery goes to sleep
		mutex.unlock();

	}
}