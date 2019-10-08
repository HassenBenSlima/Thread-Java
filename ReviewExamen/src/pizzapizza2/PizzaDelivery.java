package pizzapizza2;

// Pizza Delivery class
public class PizzaDelivery extends Thread {

	private StudyGroup studyGroup = new StudyGroup();

	public PizzaDelivery(StudyGroup sg) {
		this.studyGroup = sg;
	}

	@Override
	public void run() {
		while (true) {
			try {
				studyGroup.checkOrder();
				sleep(5000); // Wait till pizza is delivered
			} catch (InterruptedException ex) {
				ex.printStackTrace();
			}
		}
	}
}
