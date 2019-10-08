package smokers;

public class smoker extends Thread {

	private table smokingtable = new table();
	private String element;
	private int elementNumber;
	private agent controlAgent;

	public smoker(table pSmokingtable, int pElementNumber, String pName, agent pAgent) {
		// only save the number of the element, we'll get the element's name while the
		// thread is running
		elementNumber = pElementNumber;
		this.smokingtable = pSmokingtable;
		setName(pName);
		controlAgent = pAgent;
	}

	@Override
	public void run() {
		while (true) {
			element = smokingtable.getSmokerElement(elementNumber);

			if (!smokingtable.hasElement(element) && !smokingtable.isEmpty()) {
				output(getName() + " has " + element + ".");
				try {
					doSmoke();
					output(getName() + " tells the agent to start the next round.");
					// the thread tells the agent to continue
					controlAgent.wake();
				} catch (Exception e) {
				}
			}
		}
	}

	public synchronized void doSmoke() throws Exception {
		output(getName() + " rolls the cigarette.");
		Thread.sleep(2500);
		output(getName() + " smokes.");
		Thread.sleep(2500);
		output(getName() + " has finished.");
	}

	private void output(String pOutput) {
		System.out.println(pOutput);
	}
}
