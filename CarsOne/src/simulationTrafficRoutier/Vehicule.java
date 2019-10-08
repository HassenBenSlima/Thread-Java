package simulationTrafficRoutier;

import java.awt.Color;
import java.awt.image.BufferedImage;

public class Vehicule extends Thread {
	private int num;
	boolean roule = true;
	private Color clr;
	int vitesse;
	int x, y;
	String direction;
	private Carrefour carrefour;
	Route r;
	String rand;
	private BufferedImage img;

	public String getDirection() {
		return direction;
	}

	public Vehicule(int num, Color clr, int vitesse, int x, int y, String d, Carrefour f) {
		this.num = num;
		this.clr = clr;
		this.vitesse = vitesse;
		this.x = x;
		this.y = y;
		this.direction = d;
		this.carrefour = f;
	}

	public BufferedImage getImg() {
		return img;
	}

	public void setImg(BufferedImage img) {
		this.img = img;
	}

	public void setDirection(String direction) {
		this.direction = direction;
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

	public boolean isRoule() {
		return roule;
	}

	public void setRoule(boolean roule) {
		this.roule = roule;
	}

	public void move() {
		if (this.direction.equals("Horizontale"))
			this.x += this.vitesse;

		else if (this.direction.equals("Verticale"))
			this.y += this.vitesse;
	}

	public void stopp() {
		this.vitesse = 0;
	}

	public void run() {
		while (true) {
			try {
				sleep(100);
				move();

				if ((((getDirection().equals("Horizontale")) && (getVitesse() > 0))) && (x >= carrefour.getX1())
						&& (x <= carrefour.getX2())) {
					double x = 0;
					x = Math.random();
					if ((x >= 0) && (x <= 0.3))
						rand = "Droite";
					else if ((x > 0.3) && (x <= 0.6))
						rand = "Gauche";
					else
						rand = "Haut";

					carrefour.entrer(this);
					System.out.println("1");
				} else if ((((getDirection().equals("Horizontale")) && (getVitesse() < 0))) && (x <= carrefour.getX2())
						&& (x >= carrefour.getX1())) {
					double x = 0;
					x = Math.random();
					if ((x >= 0) && (x <= 0.3))
						rand = "Droite";
					else if ((x > 0.3) && (x <= 0.6))
						rand = "Gauche";
					else
						rand = "Haut";

					carrefour.entrer(this);
					System.out.println("2");
				} else if ((((getDirection().equals("Verticale")) && (getVitesse() > 0))) && (y >= carrefour.getY1())
						&& (y <= carrefour.getY2())) {
					double x = 0;
					x = Math.random();
					if ((x >= 0) && (x <= 0.3))
						rand = "Gauche";
					else if ((x > 0.3) && (x <= 0.6))
						rand = "Gauche";
					else
						rand = "Haut";

					carrefour.entrer(this);
					System.out.println("3");
				} else if ((((getDirection().equals("Verticale")) && (getVitesse() < 0))) && (y <= carrefour.getY2())
						&& (y >= carrefour.getY1())) {
					double x = 0;
					x = Math.random();
					if ((x >= 0) && (x <= 0.3))
						rand = "Droite";
					else if ((x > 0.3) && (x <= 0.6))
						rand = "Gauche";
					else
						rand = "Haut";
					// stopp();
					carrefour.entrer(this);
					System.out.println("4");
				}

			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}
}