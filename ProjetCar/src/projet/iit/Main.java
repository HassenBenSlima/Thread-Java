package projet.iit;

import java.awt.EventQueue;

public class Main {
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {

					Drive d = new Drive();
					// v1.setBounds(100,100,30,30);
					// v1.setBackground(Color.RED);
					// d.getContentPane().add(v1);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}