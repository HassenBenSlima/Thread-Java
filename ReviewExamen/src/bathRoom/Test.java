package bathRoom;

public class Test {
	public static void main(String args[]) {
		int numberOfToilets = 3;
		int occupiedCount = 0;

		Thread[] women = new Thread[3];
		Thread[] men = new Thread[3];

		BathRoom theBathRoom = new BathRoom(numberOfToilets, occupiedCount);

		for (int i = 0; i < 3; i++)
			women[i] = new Thread(new Woman(i, theBathRoom));

		for (int i = 0; i < 3; i++)
			men[i] = new Thread(new Man(i, theBathRoom));

		for (int i = 0; i < 3; i++)
			women[i].start();

		for (int i = 0; i < 3; i++)
			men[i].start();
	}
}
