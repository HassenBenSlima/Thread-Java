package bathRoom;

public class Woman implements Runnable {
	private int n; /* This identifies the woman. */
	private BathRoom theBathRoom;

	public Woman(int n, BathRoom b) {
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
				theBathRoom.woman_wants_to_enter(n);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Woman " + n + " in bathroom ");
			try {
				Thread.sleep((long) (500 * Math.random()));
			} catch (InterruptedException e) {
			}
			try {
				theBathRoom.woman_leaves(n);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}