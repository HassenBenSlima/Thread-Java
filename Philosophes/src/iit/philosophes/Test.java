package iit.philosophes;

import javax.swing.JFrame;

public class Test {

	public static void main(String[] args) {
		JFrame frmPhilosophes = new JFrame();
		frmPhilosophes.getContentPane().setLayout(null);
		frmPhilosophes.setTitle("Philosophes");
		frmPhilosophes.setBounds(100, 100, 641, 485);
		frmPhilosophes.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Philosophes p = new Philosophes();
		frmPhilosophes.getContentPane().add(p);
		frmPhilosophes.setVisible(true);
		
		Thread t1 = new Thread(p);
		t1.start();

	}

}
