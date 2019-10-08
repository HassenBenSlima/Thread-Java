package Hassen;

import java.awt.Color;
import java.util.Vector;

import javax.swing.JFrame;

public class Fenetre extends JFrame {
	private Panneau pan = new Panneau();
	private Route r1 = new Route(1, "national");

	public Fenetre() {
		this.setTitle("Animation");
		this.setSize(720, 755);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setContentPane(pan);
		this.setVisible(true);

		go();
	}

	private void go() {
		Feu f1 = new Feu(20, Color.green, 180, 450);
		Feu f2 = new Feu(20, Color.red, 220, 180);
		Feu f3 = new Feu(20, Color.green, 490, 220);
		Feu f4 = new Feu(20, Color.red, 450, 490);
		Vehicules v1 = new Vehicules(50, Color.red, 5, 10, 400);
		Vehicules v2 = new Vehicules(50, Color.red, -5, 720, 300);
		r1.addFeu(f1);
		r1.addFeu(f2);
		r1.addFeu(f3);
		r1.addFeu(f4);
		r1.addVehicule(v1);
		r1.addVehicule(v2);
		Vector<Feu> f = r1.getF();
		Vector<Vehicules> v = r1.getVehicules();

		for (int i = 0; i < f.size(); i++) {
			f.get(i).start();
		}

		for (int i = 0; i < v.size(); i++) {
			v.get(i).start();
		}

		while (true) {

			System.out.println(v1.getX());
			System.out.println(f1.getClr());
			try {
				Thread.sleep(60);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			pan.setFeu(r1.getF());
			pan.setVehicule(r1.getVehicules());
			v1.setRoule(true);
			v2.setRoule(true);
			if (v1.getX() == f1.getX() - 20 && f1.getClr().equals(Color.red))
				v1.setRoule(false);

			if (v2.getX() > f3.getX() && v2.getX() < f3.getX() + 20 && f3.getClr().equals(Color.red))
				v2.setRoule(false);

			if (v1.getX() > pan.getWidth())
				v1.setX(0);
			if (v2.getX() < 0)
				v2.setX(pan.getWidth());

			pan.repaint();
		}
	}

	public static void main(String[] args) {
		Fenetre f = new Fenetre();
	}
}