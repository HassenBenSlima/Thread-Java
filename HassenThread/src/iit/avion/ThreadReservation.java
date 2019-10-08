package iit.avion;

public class ThreadReservation extends Thread {
	
	private Avion avion;

	public ThreadReservation(Avion avion) {
		this.avion = avion;
	}

	@Override
	public void run() {
			while (avion.getNbrPlace() > 0) {
				try {

				avion.semaphore.acquire();
				avion.reserver();
				System.out.println(Thread.currentThread().getName() + "a réservé une place");
				avion.semaphore.release();

			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			}

	}

	public static void main(String[] args) {
		Avion avion = new Avion(3);
		Thread th1 = new ThreadReservation(avion);
		Thread th2 = new ThreadReservation(avion);
		Thread th3 = new ThreadReservation(avion);

		th1.start();
		th2.start();
		th3.start();

	}
}
