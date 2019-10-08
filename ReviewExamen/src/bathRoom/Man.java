package bathRoom;

public class Man implements Runnable {
	private int n; /* this identifies the man */
	private BathRoom theBathRoom;

	public Man(int n, BathRoom b) {
		this.n = n;
		this.theBathRoom = b;
	}

	public void run() {
		for (int i = 0; i < 3; i++) {

			try {
				Thread.sleep((long) (500 * Math.random()));
			} catch (InterruptedException e) {
			}

			try {
				theBathRoom.man_wants_to_enter(n);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Man " + n + " in bathroom ");
			try {
				Thread.sleep((long) (500 * Math.random()));
			} catch (InterruptedException e) {
			}
			try {
				theBathRoom.man_leaves(n);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}