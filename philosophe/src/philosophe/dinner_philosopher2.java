package philosophe;

public class dinner_philosopher2 {

	public static void main(String argv[]) {

		int philosophersNumber = 5;

		final philosopher philosophers[] = new philosopher[philosophersNumber];
		Fork forks[] = new Fork[philosophersNumber];

		for (int i = 0; i < philosophersNumber; i++) {
			forks[i] = new Fork();
		}

		for (int i = 0; i < philosophersNumber; i++) {

			Fork leftfork = forks[i];
			Fork rightfork = forks[(i + 1) % philosophersNumber];

			if (i == philosophers.length - 1) {

				// The last philosopher picks up the right fork first
				philosophers[i] = new philosopher(i, rightfork, leftfork);
			} else {
				philosophers[i] = new philosopher(i, leftfork, rightfork);
			}

			Thread t = new Thread(philosophers[i], "Philosopher " + (i + 1));
			t.start();

		}

	}
}
