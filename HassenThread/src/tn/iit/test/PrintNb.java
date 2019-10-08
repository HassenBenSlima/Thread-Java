package tn.iit.test;

public class PrintNb  implements Runnable  {
	private int nb;

	public PrintNb(int nb) {
		this.nb = nb;
	}

	public void run() {
		synchronized (this) {

			for (int i = 0; i < 5; i++) 
			{
			try {
				Thread.sleep((long)5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.print(nb+"-");
			}
		}
	}

}
