package tn.iit.concurrentcars;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.concurrent.ThreadLocalRandom;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class Car extends JPanel implements Runnable {
	private static final long serialVersionUID = 1L;

	private int x;
	private int y;
	private int width;
	private int height;
	private int vitesse;
	private int direction;
	private Thread thread;
	// private Road road;
	private int randomPosition;

	public Car(int x, int y, int width, int height) {
		super();
		this.width = width;
		this.height = height;
		this.x = x;
		this.y = y;
		this.vitesse = 1;
		setBorder(BorderFactory.createLineBorder(Color.GRAY, 2, false));
		setLayout(new BorderLayout(10, 10));
		setSize(width, height);
		setBackground(Color.BLUE);
		setLocation(x, y);
		this.setVisible(true);

		thread = new Thread(this);
		thread.start();
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getVitesse() {
		return vitesse;
	}

	public void setVitesse(int vitesse) {
		this.vitesse = vitesse;
	}

	public int getDirection() {
		return direction;
	}

	public void setDirection(int direction) {
		this.direction = direction;
	}

	void left() {
		setDirection(-1);
		setSize(getWidth(), getHeight());
		if (getVitesse() >= 0) {
			setVitesse(-getVitesse());
		}
		setX(getX() + getVitesse());
		setY(getY());
		setLocation(getX(), getY());

	}

	void rigth() {
		setDirection(1);
		setSize(getWidth(), getHeight());
		if (getVitesse() <= 0) {
			setVitesse(-getVitesse());
		}
		setX(getX() + getVitesse());
		setY(getY());
		setLocation(getX(), getY());

	}

	void down() {
		setDirection(0);
		setSize(getHeight(), getWidth());
		if (getVitesse() <= 0) {
			setVitesse(-getVitesse());
		}
		setY(getY() + getVitesse());
		setX(getX());
		setLocation(getX(), getY());
	}

	void up() {
		setDirection(2);
		setSize(getHeight(), getWidth());
		if (vitesse >= 0) {
			setVitesse(-getVitesse());
		}
		setX(getX());
		setY(getY() + getVitesse());
		setLocation(getX(), getY());

	}

	public synchronized void carInRount() {

		rigth();

		/**
		 * 2-RoundPoint 4
		 **/
		if ((getX() == 75) && (getY() == 337)) {
			randomPosition = ThreadLocalRandom.current().nextInt(0, 2);
			System.out.println(randomPosition);
			if (randomPosition == 0) {
				while (getY() > 75) {
					up();
					System.out.println(getX() + " / " + getY());
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			} else {
				while (getX() < 277) {
					rigth();
					System.out.println(getX() + " / " + getY());
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}

		/**
		 * 3-RoundPoint 1 direction=1
		 **/
		if ((getX() == 75) && (getY() == 75)) {

			while (getX() < 277) {
				rigth();
				System.out.println(getX() + " / " + getY());
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}

		/**
		 * 4-RoundPoint 2
		 **/
		if ((getX() == 277) && (getY() == 75)) {
			randomPosition = ThreadLocalRandom.current().nextInt(1, 3);
			System.out.println(randomPosition);

			if (randomPosition == 2) {
				while (getY() < 277) {
					down();
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			} else {
				while (getX() < 537) {
					rigth();
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
		/**
		 * 3-RoundPoint 2
		 **/

		if ((getX() == 337) && (getY() == 75)) {
			randomPosition = ThreadLocalRandom.current().nextInt(0, 2);
			System.out.println(randomPosition);
			if (randomPosition == 1) {
				while (getX() < 537) {
					rigth();
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			} else {
				while (getY() > 18) {
					up();
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				while (getX() > 75) {
					left();
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}

		/**
		 * 4-RoundPoint 3
		 **/
		if ((getX() == 537) && (getY() == 75)) {

			while (getY() < 277) {
				down();
				try {
					Thread.sleep(2);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}

		/**
		 * 4- RoundPoint 6
		 **/
		if ((getX() == 537) && (getY() == 337)) {
			randomPosition = 1;
			while (randomPosition == -1 || randomPosition == 1) {
				randomPosition = ThreadLocalRandom.current().nextInt(-1, 3);
			}
			System.out.println(randomPosition + " haha");
			if (randomPosition == 2) {
				while (getY() < 537) {
					down();
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			} else {
				while (getX() < 597) {
					System.out.println(" hassen");

					rigth();
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				while (getY() > 75) {
					up();
					System.out.println(" hassen2");

					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}

			}
		}

		/**
		 * 3-RoundPoint 6
		 **/
		if ((getX() == 597) && (getY() == 337)) {
			randomPosition = ThreadLocalRandom.current().nextInt(-1, 1);
			System.out.println(randomPosition + " jjjj");
			if (randomPosition == 0) {
				while (getY() > 75) {
					up();
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			} else {

				while (getY() > 277) {
					up();
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				while (getX() > 337) {
					left();
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}

		}
		/**
		 * 3-RoundPoint 3 direction=-1
		 **/
		if ((getX() == 597) && (getY() == 75)) {
			while (getY() > 18) {
				up();
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			while (getX() > 337) {
				left();
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		/**
		 * 2-RoundPoint 2
		 **/
		if ((getX() == 337) && (getY() == 18)) {
			randomPosition = 1;
			while (randomPosition == 1 || randomPosition == 0) {
				randomPosition = ThreadLocalRandom.current().nextInt(-1, 3);
			}
			System.out.println(randomPosition);
			if (randomPosition == -1) {
				while (getX() > 75) {

					left();
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			} else {
				while (getX() > 277) {

					left();
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}

				while (getY() < 277) {

					down();
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}

		}

		/**
		 * 2-RoundPoint 1 Direction=2
		 **/
		if ((getX() == 75) && (getY() == 18)) {

			while (getX() > 18) {
				left();
				System.out.println(getX() + "p / " + getY());
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			while (getY() < 277) {
				down();
				System.out.println(getX() + " b/ " + getY());
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}

		/**
		 * 1-RoundPoint 4
		 **/
		if ((getX() == 18) && (getY() == 277)) {
			randomPosition = ThreadLocalRandom.current().nextInt(1, 3);
			System.out.println(randomPosition);

			if (randomPosition == 2) {
				while (getY() < 537) {
					down();
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

				}
			} else {
				while (getY() < 337) {
					down();
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				while (getX() < 277) {
					rigth();
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}

			}
		}
		/**
		 * 1-RoundPoint 7
		 */
		if ((getX() == 18) && (getY() == 537)) {
			while (getY() < 597) {
				down();
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			while (getX() < 277) {
				rigth();
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}

		/**
		 * 1-RoundPoint 6
		 **/
		if ((getX() == 537) && (getY() == 277)) {

			randomPosition = 1;
			while (randomPosition == 1 || randomPosition == 0) {
				randomPosition = ThreadLocalRandom.current().nextInt(-1, 3);
			}
			System.out.println(randomPosition);
			if (randomPosition == -1) {
				while (getX() > 337) {
					left();
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			} else {
				while (getY() < 537) {
					down();
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
		/**
		 * 1-RoundPoint 9 direction=-1
		 */
		if ((getX() == 537) && (getY() == 537)) {

			while (getX() > 337) {

				left();
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}

		/**
		 * 2-RoundPoint 8
		 **/
		if ((getX() == 337) && (getY() == 537)) {
			randomPosition = ThreadLocalRandom.current().nextInt(-1, 1);
			System.out.println(randomPosition);
			if (randomPosition == -1) {
				while (getX() > 75) {
					left();
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			} else {
				while (getY() > 337) {
					up();
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}

		/**
		 * 4-RoundPoint 8
		 **/
		if ((getX() == 277) && (getY() == 597)) {
			randomPosition = 1;// ThreadLocalRandom.current().nextInt(0, 2);
			System.out.println(randomPosition);
			if (randomPosition == 0) {
				while (getX() < 337) {
					rigth();
					System.out.println("opaR");

					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}

				while (getY() > 337) {
					up();
					System.out.println("opaU");

					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			} else {
				while (getX() < 537) {
					rigth();
					System.out.println("opaR");

					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
		/**
		 * 4-RoundPoint 9 direction=0
		 **/
		if ((getX() == 537) && (getY() == 597)) {
			while (getX() < 597) {
				rigth();
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			while (getY() > 337) {
				up();
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}

		/**
		 * 1-RoundPoint 5
		 **/
		if ((getX() == 277) && (getY() == 277)) {
			randomPosition = 0;
			while (randomPosition == 0) {
				randomPosition = ThreadLocalRandom.current().nextInt(-1, 3);
			}
			System.out.println(randomPosition);
			if (randomPosition == -1) {
				while (getX() > 75) {
					left();
					System.out.println("doudi");

					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			} else if (randomPosition == 2) {
				while (getY() < 537) {
					down();
					System.out.println("doudi");
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			} else {
				while (getY() < 337) {
					down();
					System.out.println("doudi");
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				// System.out.println(getX()+"//"+getY());
				while (getX() < 537) {
					rigth();
					System.out.println("doudi");
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}

			}

		}
		/**
		 * 2-RoundPoint 4
		 **/
		if ((getX() == 75) && (getY() == 277)) {
			while (getY() > 75) {
				up();
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}

		/**
		 * 2-RoundPoint 5
		 **/
		if ((getX() == 337) && (getY() == 277)) {
			randomPosition = 1;
			while (randomPosition == 1) {
				randomPosition = ThreadLocalRandom.current().nextInt(-1, 3);
			}
			System.out.println(randomPosition);
			if (randomPosition == -1) {
				while (getY() > 75) {
					left();
					System.out.println("aa");

					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			} else if (randomPosition == 0) {
				while (getY() > 75) {
					up();
					System.out.println("bb");
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			} else {
				while (getX() > 277) {
					left();
					System.out.println("cc");
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				while (getY() < 537) {
					down();
					System.out.println("op");
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}

		}

		/**
		 * 3-RoundPoint 5
		 **/
		if ((getX() == 337) && (getY() == 337)) {
			randomPosition = 2;
			while (randomPosition == 2) {
				randomPosition = ThreadLocalRandom.current().nextInt(-1, 3);
			}
			System.out.println(randomPosition);
			if (randomPosition == 1) {
				while (getX() < 537) {
					rigth();
					System.out.println("3-one5");

					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			} else if (randomPosition == 0) {
				while (getY() > 75) {
					up();
					System.out.println("3-zero5");

					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			} else {
				while (getY() > 277) {
					up();
					System.out.println("3-minusOne5");

					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				while (getX() > 75) {
					left();
					System.out.println("3-minusOne5");

					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}

		}

		/**
		 * 4-RoundPoint 5
		 **/
		if ((getX() == 277) && (getY() == 337)) {
			randomPosition = -1;
			while (randomPosition == -1) {
				randomPosition = ThreadLocalRandom.current().nextInt(-1, 3);
			}
			System.out.println(randomPosition);
			if (randomPosition == 1) {
				while (getX() < 537) {
					rigth();
					System.out.println("4-one5");

					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			} else if (randomPosition == 2) {
				while (getY() < 537) {
					down();
					System.out.println("4-Two5");

					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			} else {
				while (getX() < 337) {
					rigth();
					System.out.println("4-zero5");

					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				while (getY() > 75) {
					up();
					System.out.println("4-zero5");

					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}

		}

		/**
		 * 1-RoundPoint 8
		 **/
		if ((getX() == 277) && (getY() == 537)) {

			while (getX() > 75) {
				left();
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}

		/**
		 * 2-RoundPoint 7
		 **/
		if ((getX() == 75) && (getY() == 537)) {
			while (getY() > 337) {
				up();
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}

	}

	public void updatePosition(int a) {

		if (a == -1) {
			left();

		} else if (a == 1) {
			rigth();
		} else if (a == 0) {
			up();

		} else if (a == 2) {
			down();

		}

	}

	public void movementX() {
		System.out.print(randomPosition + ",");
		// setLocation(getX(), getY());
		updatePosition(randomPosition);

		if ((getX() == 18) || ((getY() == 18))) {
			randomPosition = ThreadLocalRandom.current().nextInt(-1, 3);

		}

	}

	public void movementY() {
		randomPosition = ThreadLocalRandom.current().nextInt(-1, 3);
		System.out.print(randomPosition + ",");
		setY(getY() + getVitesse());
		// setLocation(getX(), getY());

	}

	public static void move(int width, int height, Car car) {
		if (car.getX() < 0) {
			// car.setVelY(0);
			car.setX(0);

		}
		if (car.getX() > width) {
			car.setX(0);
			// car.setVelX(0);
		}

		if (car.getY() < 0) {
			// car.setVelY(0);
			car.setY(0);
		}
		if (car.getY() > height) {
			// car.setVelY(0);
			// car.setVelY(height);
		}

	}

	@Override
	public void run() {
		while (true) {

			// Random r = new Random();
			// int Low = 10;
			// int High = 100;
			// int Result = r.nextInt(High-Low) + Low;
			// System.out.println(Result);
			carInRount();

			// down();

			// updatePosition(1);
			// carInRount();
			// setLocation(getX(), getY());

			// movementX();
			// if (((getX() == 277) && (getY() == 18))) {
			// down();
			// System.out.println("------------------------------------"+this.getX());
			// System.out.println(this.getY());
			// }
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				System.out.println("Error in executing thread:" + e);
			}
		}
	}

}
