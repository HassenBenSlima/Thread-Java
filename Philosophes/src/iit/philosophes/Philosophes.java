package iit.philosophes;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.util.concurrent.Semaphore;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Philosophes extends JPanel implements Runnable {

	private static final long serialVersionUID = 1L;
	private String[] etat;
	public String[] etat_philosophe;
	private Semaphore sphilo;
	private Semaphore smutex;
	private final int nbrePhilosophes = 5;
	private Semaphore stabel;
	private int i = 0;

	Image image1 = new ImageIcon("pictures/Pense.png").getImage();
	Image image2 = new ImageIcon("pictures/Pense.png").getImage();
	Image image3 = new ImageIcon("pictures/Pense.png").getImage();
	Image image4 = new ImageIcon("pictures/Pense.png").getImage();
	Image image5 = new ImageIcon("pictures/Pense.png").getImage();

	public Philosophes() {
		smutex = new Semaphore(1, true);
		sphilo = new Semaphore(0, true);
		stabel = new Semaphore(1, true);
		etat_philosophe = new String[] { "pense", "pense", "pense", "pense", "pense" };
		etat = new String[] { "pense", "attend", "mange" };

		this.setBounds(43, 11, 641, 485);
		this.setLayout(null);
		scene();

	}

	public void scene() {
		File file1 = new File("pictures/Pizza-icon.png");

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(158, 116, 79, 72);
		lblNewLabel.setIcon(new ImageIcon(file1.toString()));
		this.add(lblNewLabel);

		JLabel label = new JLabel("");
		label.setBounds(347, 116, 85, 72);
		label.setIcon(new ImageIcon(file1.toString()));
		this.add(label);

		JLabel label_1 = new JLabel("");
		label_1.setBounds(97, 215, 85, 72);
		label_1.setIcon(new ImageIcon(file1.toString()));
		this.add(label_1);

		JLabel label_2 = new JLabel("");
		label_2.setBounds(260, 271, 85, 72);
		label_2.setIcon(new ImageIcon(file1.toString()));
		this.add(label_2);

		JLabel label_3 = new JLabel("");
		label_3.setBounds(429, 215, 85, 72);
		label_3.setIcon(new ImageIcon(file1.toString()));
		this.add(label_3);

	}

	public void afficheTable() {

		// pense

		if ("pense".equals(etat_philosophe[0])) {
			image1 = new ImageIcon("pictures/Pense.png").getImage();
			repaint();
		}
		if (etat_philosophe[1] == "pense")

		{
			image2 = new ImageIcon("pictures/Pense.png").getImage();
			repaint();
		}
		if (etat_philosophe[2] == "pense") {
			image3 = new ImageIcon("pictures/Pense.png").getImage();
			repaint();
		}
		if (etat_philosophe[3] == "pense") {
			image4 = new ImageIcon("pictures/Pense.png").getImage();
			repaint();
		}
		if (etat_philosophe[4] == "pense") {
			image5 = new ImageIcon("pictures/Pense.png").getImage();
			repaint();
		}
		// anttend
		if (etat_philosophe[0] == "attend") {
			image1 = new ImageIcon("pictures/attend.png").getImage();
			repaint();
		}
		if (etat_philosophe[1] == "attend") {
			image2 = new ImageIcon("pictures/attend.png").getImage();
			repaint();
		}
		if (etat_philosophe[2] == "attend") {
			image3 = new ImageIcon("pictures/attend.png").getImage();
			repaint();
		}
		if (etat_philosophe[3] == "attend") {
			image4 = new ImageIcon("pictures/attend.png").getImage();
			repaint();
		}
		if (etat_philosophe[4] == "attend") {
			image5 = new ImageIcon("pictures/attend.png").getImage();
			repaint();
		}
		// mange
		if (etat_philosophe[0] == "mange") {
			image1 = new ImageIcon("pictures/eat.png").getImage();
			repaint();
		}
		if (etat_philosophe[1] == "mange") {
			image2 = new ImageIcon("pictures/eat.png").getImage();
			repaint();
		}
		if (etat_philosophe[2] == "mange") {
			image3 = new ImageIcon("pictures/eat.png").getImage();
			repaint();
		}
		if (etat_philosophe[3] == "mange") {
			image4 = new ImageIcon("pictures/eat.png").getImage();
			repaint();
		}
		if (etat_philosophe[4] == "mange") {
			image5 = new ImageIcon("pictures/eat.png").getImage();
			repaint();
		}

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void manger(int i) {

		if (etat_philosophe[(i - 1 + nbrePhilosophes) % nbrePhilosophes] != etat[2]
				&& etat_philosophe[(i + 1) % nbrePhilosophes] != etat[2] && etat_philosophe[i] == etat[1]) {
			etat_philosophe[i] = etat[2];

		}
	}

	public void prendFourchette() {
		try {
			stabel.acquire();
			smutex.acquire();
			etat_philosophe[i] = etat[1];
			System.out.println(i);
			afficheTable();
			manger(i);
			afficheTable();

		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			smutex.release();
			sphilo.release();
		}
		try {
			Thread.sleep(300);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void poseFourchette() {
		try {
			sphilo.acquire();
			smutex.acquire();
			etat_philosophe[i] = etat[0];

			afficheTable();
			int a = (i - 1 + nbrePhilosophes) % nbrePhilosophes;
			int b = (i + 1) % nbrePhilosophes;

			etat_philosophe[a] = etat[1];
			etat_philosophe[b] = etat[1];
			afficheTable();
			manger(a);
			manger(b);
			afficheTable();
			etat_philosophe[a] = etat[0];
			etat_philosophe[b] = etat[0];
			afficheTable();

			i = (i + 1) % nbrePhilosophes;

		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			smutex.release();
			stabel.release();
		}
		try {
			Thread.sleep(300);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.drawImage(image1, 33, 188, null);
		g.drawImage(image2, 192, 31, null);
		g.drawImage(image3, 381, 31, null);
		g.drawImage(image4, 540, 211, null);
		g.drawImage(image5, 292, 350, null);
	}

	@Override
	public void run() {

		while (true) {
			try {

				prendFourchette();

				poseFourchette();

				Thread.sleep(300);

			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}

	}

}
