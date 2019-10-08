package smokers;

public class agent extends Thread {

	private table smokingtable;

	public agent(table pSmokingtable) {
		smokingtable = pSmokingtable;
	}

	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(5000);
				smokingtable.setAgentElements();
				// this triggers the smoker-threads to look at the table
				output("The agents puts " + smokingtable.getAgentElements() + " on the table.");
				// pause the agent while one smoker thread is running
				pause();
			} catch (Exception e) {

			}
		}
	}

	public synchronized void wake() {
		try {
			notify();
		} catch (Exception e) {
		}
	}

	public synchronized void pause() {
		try {
			this.wait();
		} catch (Exception e) {
		}
	}

	private void output(String pOutput) {
		System.out.println(pOutput);
	}
}
