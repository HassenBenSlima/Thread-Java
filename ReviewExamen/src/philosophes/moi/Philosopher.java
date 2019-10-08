package philosophes.moi;

public class Philosopher implements Runnable {

	protected ChopStick rightChopStrick;
	protected ChopStick leftChopStrick;
	protected int id;
	volatile boolean tummyFull = false;
	protected int nbreTryEating;

	public Philosopher(ChopStick leftChopStrick, ChopStick rightChopStrick, int id) {
		super();
		this.rightChopStrick = rightChopStrick;
		this.leftChopStrick = leftChopStrick;
		this.id = id;
	}

	public void think() {
		try {
			System.out.println(this + "Thinking");
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void eat() {
		try {
			System.out.println(this + " is eating");
			nbreTryEating++;
			Thread.sleep(1000);
		} catch (Exception e) {
			e.getStackTrace();
		}
	}

	@Override
	public String toString() {
		return "Philosopher [" + id + "]";
	}

	@Override
	public void run() {

		try {
			while (!tummyFull) {
				think();
				if (leftChopStrick.pickUp(this, "left")) {
					if (rightChopStrick.pickUp(this, "right")) {
						eat();
						rightChopStrick.putDown(this, "leright");
					}
					leftChopStrick.putDown(this, "left");
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
