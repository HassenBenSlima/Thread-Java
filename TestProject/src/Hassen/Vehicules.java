package Hassen;

import java.awt.*;

public class Vehicules extends Thread {
	private int num;
	private boolean roule = true;
	private Color clr;
	private int vitesse;
	private int x, y;

	public Vehicules(int num, Color clr, int vitesse, int x, int y) {
		this.num = num;
		this.clr = clr;
		this.vitesse = vitesse;
		this.x = x;
		this.y = y;
	}

	public int getNum() {
		return num;
	}

	public void setId(int num) {
		this.num = num;
	}

	public Color getClr() {
		return clr;
	}

	public void setClr(Color clr) {
		this.clr = clr;
	}

	public int getVitesse() {
		return vitesse;
	}

	public void setVitesse(int vitesse) {
		this.vitesse = vitesse;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void move() {
		x = x + vitesse;
	}

	public boolean isRoule() {
		return roule;
	}

	public void setRoule(boolean roule) {
		this.roule = roule;
	}

	public void run() {
		while (true) {
			try {
				sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (isRoule())
				move();
		}
	}
}
