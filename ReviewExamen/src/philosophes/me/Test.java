package philosophes.me;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test {

	public static void main(String args[]) throws InterruptedException {
		// How many to test with.
		int NO_OF_PHILOSOPHER = 5;
		// private static final int SIMULATION_MILLIS = 1000 * 60 * 8;
		int SIMULATION_MILLIS = 1000 * 10;
		ExecutorService executorService = null;

		Philosopher[] philosophers = null;
		try {
			// 5 philosophers
			philosophers = new Philosopher[NO_OF_PHILOSOPHER];
			// As many forks as Philosophers
			ChopStick[] chopSticks = new ChopStick[NO_OF_PHILOSOPHER];

			// Cannot do this as it will fill the whole array with the SAME chopstick.
			for (int i = 0; i < NO_OF_PHILOSOPHER; i++) {
				chopSticks[i] = new ChopStick(i);
			}

			executorService = Executors.newFixedThreadPool(NO_OF_PHILOSOPHER);

			for (int i = 0; i < NO_OF_PHILOSOPHER; i++) {
				philosophers[i] = new Philosopher(i, chopSticks[i], chopSticks[(i + 1) % NO_OF_PHILOSOPHER]);
				executorService.execute(philosophers[i]);
			}
			// Main thread sleeps till time of simulation
			Thread.sleep(SIMULATION_MILLIS);
			// Stop all philosophers.
			for (Philosopher philosopher : philosophers) {
				philosopher.isTummyFull = true;
			}

		} finally {
			// Close everything down.
			executorService.shutdown();

			// Wait for all thread to finish
			while (!executorService.isTerminated()) {
				Thread.sleep(1000);
			}

			// Time for check
			for (Philosopher philosopher : philosophers) {
				System.out.println(philosopher + " => No of Turns to Eat =" + philosopher.getNoOfTurnsToEat());
			}
		}
	}
}
