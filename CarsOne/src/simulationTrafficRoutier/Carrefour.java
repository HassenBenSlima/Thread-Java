package simulationTrafficRoutier;

import java.util.concurrent.Semaphore;

public class Carrefour {

	private String nom;
	private int x1;// limite gauche du carrefour
	private int x2;// limite droite du carrefour
	private int y1;// limite haute du carefour
	private int y2;// limite basse du carrefour
	private Semaphore sem_11 = new Semaphore(1, true);
	private Semaphore sem_12 = new Semaphore(1, true);
	private Semaphore sem_21 = new Semaphore(1, true);
	private Semaphore sem_22 = new Semaphore(1, true);
	private Semaphore sem = new Semaphore(1, true);
	boolean enter = true;

	public Carrefour(String nom, int x1, int x2, int y1, int y2) {
		this.nom = nom;
		this.x1 = x1;
		this.x2 = x2;
		this.y1 = y1;
		this.y2 = y2;
	}

	public void entrer(Vehicule v) throws InterruptedException {
		if ((v.vitesse > 0) && (v.direction.equals("Horizontale")) && (v.x >= x1) && (v.y >= 160)) {
			int s = (x1 + x2) / 2;
			switch (v.rand) {
			case "Droite": {
				sem_21.acquire(); // ACQUIRE SEMAPHORE 21

				v.setDirection("Horizontale");
				while ((v.x >= x1) && (v.x <= (s - 50))) {
					v.vitesse = 10;
					v.move();
					v.sleep(100);
					System.out.println("yemchi");

				}
				v.setDirection("Verticale");

				while ((v.y >= y1) && (v.y <= y2)) {
					v.vitesse = 10;
					v.move();
					v.sleep(100);
					System.out.println("yemchi3");
				}
				System.out.println("yyy");
				enter = true;

				sem_21.release(); // ACQUIRE SEMAPHORE 21

				// sem.release(); //
				v.move();
				break;
			}
			case "Gauche": {
				do {
					v.sleep(100);
				} while ((sem_12.availablePermits() == 0) || (sem_21.availablePermits() == 0)
						|| (sem_22.availablePermits() == 0));

				sem_12.acquire();
				sem_21.acquire();
				sem_22.acquire();

				v.setDirection("Horizontale");
				v.setVitesse(10);
				while ((v.x >= x1) && (v.x <= (s + 50))) {
					// v.vitesse = 10;

					v.move();
					v.sleep(100);
					System.out.println("yemchi");
				}

				v.setDirection("Verticale");
				v.setVitesse(-10);
				while ((v.y >= y1) && (v.y <= y2)) {
					// v.vitesse = -10;
					v.move();
					v.sleep(100);
					System.out.println("yemchi4");
				}
				System.out.println("yyy");
				enter = true;
				sem_12.release();
				sem_22.release();
				sem_21.release();
				// sem.release();
				v.move();
				break;
			}
			case "Haut": {
				do {
					v.sleep(100);
				} while ((sem_21.availablePermits() == 0) || (sem_22.availablePermits() == 0));
				sem_21.acquire();
				sem_22.acquire();

				v.setDirection("Horizontale");
				v.setVitesse(10);
				while ((v.x >= x1) && (v.x <= x2)) {
					// v.vitesse = 10;
					v.move();
					v.sleep(100);
					System.out.println("yemchi");
				}
				System.out.println("yyy");
				enter = true;
				sem_22.release();
				sem_21.release();

				// sem.release();
				break;
			}

			}

			// notifyAll();
		} else if ((v.vitesse < 0) && (v.direction.equals("Horizontale")) && (v.x <= x2)) {
			int s = (x1 + x2) / 2;
			switch (v.rand) {
			case "Droite": {
				sem_12.acquire();

				v.setDirection("Horizontale");
				v.setVitesse(-10);
				while ((v.x >= (s + 50)) && (v.x <= x2)) {
					v.vitesse = -10;
					v.move();
					v.sleep(100);
					System.out.println("yemchi2");
				}
				v.setDirection("Verticale");
				v.setVitesse(-10);
				while ((v.y >= y1) && (v.y <= y2)) {
					// v.vitesse = 10;
					v.move();
					v.sleep(100);
					System.out.println("yemchi3");
				}
				System.out.println("yyy2");
				enter = true;
				sem_12.release();
				// sem.release();
				break;
				// notifyAll();

			}
			case "Gauche": {
				do {
					v.sleep(100);
				} while ((sem_12.availablePermits() == 0) || (sem_21.availablePermits() == 0)
						|| (sem_11.availablePermits() == 0));

				sem_12.acquire();
				sem_21.acquire();
				sem_11.acquire();

				v.setDirection("Horizontale");
				v.setVitesse(-10);
				while ((v.x >= (s - 50)) && (v.x <= x2)) {
					v.vitesse = -10;
					v.move();
					v.sleep(100);
					System.out.println("yemchi2");
				}
				v.setDirection("Verticale");
				v.setVitesse(10);
				while ((v.y >= y1) && (v.y <= y2)) {
					// v.vitesse = 10;
					v.move();
					v.sleep(100);
					System.out.println("yemchi3");
				}
				System.out.println("yyy2");
				enter = true;
				// sem.release();
				sem_12.release();
				sem_21.release();
				sem_11.release();
				break;
				// notifyAll();

			}
			case "Haut": {
				do {
					v.sleep(100);
				} while ((sem_12.availablePermits() == 0) || (sem_11.availablePermits() == 0));
				sem_12.acquire();
				sem_11.acquire();

				v.setDirection("Horizontale");
				v.setVitesse(-10);
				while ((v.x >= x1) && (v.x <= x2)) {
					// v.vitesse = 10;
					v.move();
					v.sleep(100);
					System.out.println("yemchi");
				}
				System.out.println("yyy");
				enter = true;
				sem_11.release();
				sem_12.release();
				// sem.release();
				break;
			}

			}
		} else if ((v.vitesse > 0) && (v.direction.equals("Verticale")) && (v.y >= y1)) {
			int s = (y1 + y2) / 2;
			switch (v.rand) {
			case "Droite": {
				sem_11.acquire();
				v.setDirection("Verticale");
				v.setVitesse(10);
				while ((v.y >= y1) && (v.y <= (s - 50))) {
					v.vitesse = 10;
					v.move();
					v.sleep(100);
					System.out.println("yemchi");

				}
				v.setDirection("Horizontale");
				v.setVitesse(-10);
				while ((v.y >= y1) && (v.y <= y2)) {
					v.vitesse = 10;
					v.move();
					v.sleep(100);
					System.out.println("yemchi3");
				}
				System.out.println("yyy");
				enter = true;
				sem_11.release();
				// sem.release();
				v.move();
				break;

			}
			case "Gauche": {
				do {
					v.sleep(100);
				} while ((sem_11.availablePermits() == 0) || (sem_21.availablePermits() == 0)
						|| (sem_22.availablePermits() == 0));
				sem_11.acquire();
				sem_21.acquire();
				sem_22.acquire();

				v.setDirection("Verticale");
				v.setVitesse(10);
				while ((v.y >= y1) && (v.y <= (s + 50))) {
					// v.vitesse = 10;

					v.move();
					v.sleep(100);
					System.out.println("yemchi");
				}
				v.setDirection("Horizontale");
				v.setVitesse(10);
				while ((v.x >= x1) && (v.x <= x2) && (v.y >= (s))) {
					// v.vitesse = -10;
					v.move();
					v.sleep(100);
					System.out.println("yemchi4");
				}
				System.out.println("yyy");
				enter = true;
				sem_11.release();
				sem_21.release();
				sem_22.release();
				// sem.release();
				v.move();
				break;

			}
			case "Haut": {

				do {
					v.sleep(100);
				} while ((sem_11.availablePermits() == 0) || (sem_21.availablePermits() == 0));
				sem_11.acquire();
				sem_21.acquire();

				v.setDirection("Verticale");
				v.setVitesse(10);
				while ((v.y >= y1) && (v.y <= y2)) {
					// v.vitesse=10;
					v.move();
					v.sleep(100);
					System.out.println("yemchi3");
				}
				System.out.println("yyy3");
				enter = true;
				sem_11.release();
				sem_21.release();
				// sem.release();
				break;
				// notifyAll();
			}

			}

		} else if ((v.vitesse < 0) && (v.direction.equals("Verticale")) && (v.y <= y2)) {
			int s = (y1 + y2) / 2;
			switch (v.rand) {
			case "Droite": {
				sem_22.acquire();

				v.setDirection("Verticale");
				v.setVitesse(-10);
				while ((v.y <= y2) && (v.y >= (s + 50))) {
					v.vitesse = -10;
					v.move();
					v.sleep(100);
					System.out.println("yemchi2");
				}
				v.setDirection("Horizontale");
				v.setVitesse(10);
				while ((v.x >= x1) && (v.x <= x2)) {
					// v.vitesse = 10;
					v.move();
					v.sleep(100);
					System.out.println("yemchi3");
				}
				System.out.println("yyy2");
				enter = true;
				sem_22.release();
				// sem.release();
				break;
				// notifyAll();

			}
			case "Gauche": {
				do {
					v.sleep(100);
				} while ((sem_12.availablePermits() == 0) || (sem_11.availablePermits() == 0)
						|| (sem_22.availablePermits() == 0));

				sem_12.acquire();
				sem_22.acquire();
				sem_11.acquire();

				v.setDirection("Verticale");
				v.setVitesse(-10);

				while ((v.y <= y2) && (v.y >= (s - 50))) {
					v.vitesse = -10;
					v.move();
					v.sleep(100);
					System.out.println("yemchi2");
				}
				v.setDirection("Horizontale");
				v.setVitesse(-10);
				while ((v.x >= x1) && (v.x <= x2)) {
					// v.vitesse = 10;
					v.move();
					v.sleep(100);
					System.out.println("yemchi3");
				}
				System.out.println("yyy2");
				enter = true;
				// sem.release();
				sem_12.release();
				sem_22.release();
				sem_11.release();
				break;
				// notifyAll();

			}
			case "Haut": {
				do {
					v.sleep(100);
				} while ((sem_12.availablePermits() == 0) || (sem_22.availablePermits() == 0));
				sem_12.acquire();
				sem_22.acquire();
				v.setDirection("Verticale");
				v.setVitesse(-10);
				while ((v.y >= y1) && (v.y <= y2)) {
					v.vitesse = -10;
					v.move();
					v.sleep(100);
					System.out.println("yemchi4");
				}
				System.out.println("yyy4");
				enter = true;
				sem_22.release();
				sem_12.release();
				// sem.release();
				break;

			}

			}

		}

	}

	public void sortir() {
		sem.release();
	}

	public int getX1() {
		return x1;
	}

	public void setX1(int x1) {
		this.x1 = x1;
	}

	public int getX2() {
		return x2;
	}

	public void setX2(int x2) {
		this.x2 = x2;
	}

	public int getY1() {
		return y1;
	}

	public void setY1(int y1) {
		this.y1 = y1;
	}

	public int getY2() {
		return y2;
	}

	public void setY2(int y2) {
		this.y2 = y2;
	}

}