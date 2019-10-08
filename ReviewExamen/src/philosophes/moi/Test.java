/**
 * 
 */
package philosophes.moi;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author azuse
 *
 */
public class Test {

	public static void main(String[] args) throws InterruptedException {
		Philosopher[] philosophers = new Philosopher[5];
		ChopStick[] chopSticks = new ChopStick[5];
		ExecutorService executorService = Executors.newFixedThreadPool(5);
		try {
			for (int i = 0; i < 5; i++) {
				chopSticks[i] = new ChopStick(i);
			}

			for (int i = 0; i < 5; i++) {
				philosophers[i] = new Philosopher(chopSticks[i], chopSticks[(i + 1) % 5], i);
				executorService.execute(philosophers[i]);
			}
			Thread.sleep(10000);
			for (Philosopher p : philosophers) {
				p.tummyFull = true;
			}

		} finally {
			executorService.shutdown();

			while (!executorService.isTerminated()) {
				Thread.sleep(1000);
			}

			for (Philosopher p : philosophers) {
				System.out.println(p + "=> Turn to Eat =" + p.nbreTryEating);
			}

		}

	}

}
