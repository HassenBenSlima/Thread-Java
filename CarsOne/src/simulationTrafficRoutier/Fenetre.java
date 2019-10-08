package simulationTrafficRoutier;
import java.awt.Color;
import java.util.Vector;
import java.util.concurrent.Semaphore;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Fenetre extends JFrame {
	private Panneau pan = new Panneau();
	private Route r1 = new Route(1, "national");

	public Fenetre() throws InterruptedException {
		this.setTitle("Animation");
		this.setSize(720, 755);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setContentPane(pan);
		this.setVisible(true);
		this.setResizable(false);

		go();
	}

	private void go() throws InterruptedException {
		Carrefour C = new Carrefour("Carrefour", 120, 510, 120, 500);
		// Feu f1 = new Feu(20, Color.green, 180, 450);
		// Feu f2 = new Feu(20, Color.red, 220, 180);
		// Feu f3 = new Feu(20, Color.green, 490, 220);
		// Feu f4 = new Feu(20, Color.red, 450, 490);
		Vehicule v1 = new Vehicule(1, Color.red, 5, 10, 367, "Horizontale",C);
		Vehicule v2 = new Vehicule(2, Color.blue, -10, 720, 260, "Horizontale",C);
		Vehicule v3 = new Vehicule(3, Color.CYAN, 20, 260, 10, "Verticale",C);
		Vehicule v4 = new Vehicule(4, Color.magenta, -15, 370, 720, "Verticale",C);
		// r1.addFeu(f1);
		// r1.addFeu(f2);
		// r1.addFeu(f3);
		// r1.addFeu(f4);
		r1.addVehicule(v1);
		r1.addVehicule(v2);
		r1.addVehicule(v3);
		r1.addVehicule(v4);
		// Vector<Feu> f = r1.getF();
		Vector<Vehicule> v = r1.getVehicules();

		// for (int i = 0; i < f.size(); i++) {
		// f.get(i).start();
		// }

		// for (int i = 0; i < v.size(); i++) {
		// v.get(i).start();
		// }
		for (Vehicule vv : v) {
			vv.start();
		}

		while (true) {

			// System.out.println(v1.getX());
			// System.out.println(f1.getClr());
			try {
				Thread.sleep(60);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			// pan.setFeu(r1.getF());
			pan.setVehicule(r1.getVehicules());

			

//			if (v1.getX() == 120) 
//			{
//				v1.setRoule(false);
//				
//
//			}
//			if (v2.getX() == 510)
//			{
//				v2.setRoule(false);
//				
//			}
//			if (v3.getY() == 100)
//			{
//				v3.setRoule(false);
//				
//			}
//			if (v4.getY() == 520)
//			{
//				v4.setRoule(false);
//			}

			// if (v1.getX() == f1.getX() - 20 && f1.getClr().equals(Color.red))
			// v1.setRoule(false);

			// if (v2.getX() > f3.getX() && v2.getX() < f3.getX() + 20 &&
			// f3.getClr().equals(Color.red))
			// v2.setRoule(false);

			if (v1.getX() > pan.getWidth())
				v1.setX(0);
			else if (v1.getX() < 0)
				v1.setX(pan.getWidth());
			else if (v1.getY() > pan.getHeight())
				v1.setY(0);
			else if (v1.getY() < 0)
				v1.setY(pan.getHeight());
			
			if (v2.getX() > pan.getWidth())
				v2.setX(0);
			else if (v2.getX() < 0)
				v2.setX(pan.getWidth());
			else if (v2.getY() > pan.getHeight())
				v2.setY(0);
			else if (v2.getY() < 0)
				v2.setY(pan.getHeight());
			
			if (v3.getX() > pan.getWidth())
				v3.setX(0);
			else if (v3.getX() < 0)
				v3.setX(pan.getWidth());
			else if (v3.getY() > pan.getHeight())
				v3.setY(0);
			else if (v3.getY() < 0)
				v3.setY(pan.getHeight());
			
			if (v4.getX() > pan.getWidth())
				v4.setX(0);
			else if (v4.getX() < 0)
				v4.setX(pan.getWidth());
			else if (v4.getY() > pan.getHeight())
				v4.setY(0);
			else if (v4.getY() < 0)
				v4.setY(pan.getHeight());

			pan.repaint();
		}
	}

	public static void main(String[] args) throws InterruptedException {
		Fenetre f = new Fenetre();
	
	}
}