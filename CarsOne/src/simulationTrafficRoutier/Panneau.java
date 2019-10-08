package simulationTrafficRoutier;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Vector;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Panneau extends JPanel {
	// Vector<Feu> f;
	Vector<Vehicule> v;

	public void paintComponent(Graphics g) {

//		g.setColor(Color.white);
//		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		BufferedImage img = null;
		try {
			img = ImageIO.read(new File("texture-gazon.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		g.drawImage(img, 0, 0, null);

		/* route horizontale */
		g.setColor(Color.darkGray);
		g.fillRect(0, 250, 720, 200);

		g.setColor(Color.white);
		g.fillRect(10, 340, 60, 20);
		//**************************
		g.setColor(Color.red);
		g.fillRect(230, 0, 20, 60);
		
		g.setColor(Color.white);
		g.fillRect(230, 60, 20, 60);
		
		g.setColor(Color.red);
		g.fillRect(230, 120, 20, 60);
		
		g.setColor(Color.white);
		g.fillRect(230, 180, 20, 60);
		//*********************
		g.setColor(Color.red);
		g.fillRect(450, 0, 20, 60);
		
		g.setColor(Color.white);
		g.fillRect(450, 60, 20, 60);
		
		g.setColor(Color.red);
		g.fillRect(450, 120, 20, 60);
		
		g.setColor(Color.white);
		g.fillRect(450, 180, 20, 60);
		//***********************
		g.setColor(Color.red);
		g.fillRect(230, 470, 20, 70);
		
		g.setColor(Color.white);
		g.fillRect(230, 540, 20, 60);
		
		g.setColor(Color.red);
		g.fillRect(230, 600, 20, 60);
		
		g.setColor(Color.white);
		g.fillRect(230, 660, 20, 70);
		//
		g.setColor(Color.red);
		g.fillRect(450, 470, 20, 70);
		
		g.setColor(Color.white);
		g.fillRect(450, 540, 20, 60);
		
		g.setColor(Color.red);
		g.fillRect(450, 600, 20, 60);
		
		g.setColor(Color.white);
		g.fillRect(450, 660, 20, 70);
		//***********************
		g.setColor(Color.red);
		g.fillRect(0, 230, 60, 20);
		
		g.setColor(Color.white);
		g.fillRect(60, 230, 60, 20);
		
		g.setColor(Color.red);
		g.fillRect(120, 230, 60, 20);
		
		g.setColor(Color.white);
		g.fillRect(180, 230, 70, 20);
		//**********************
		g.setColor(Color.white);
		g.fillRect(0, 450, 60, 20);
		
		g.setColor(Color.red);
		g.fillRect(60, 450, 60, 20);
		
		g.setColor(Color.white);
		g.fillRect(120, 450, 60, 20);
		
		g.setColor(Color.red);
		g.fillRect(180, 450, 70, 20);
		//**********************
		g.setColor(Color.red);
		g.fillRect(450, 450, 70, 20);
		
		g.setColor(Color.white);
		g.fillRect(520, 450, 60, 20);
		
		g.setColor(Color.red);
		g.fillRect(580, 450, 60, 20);
		
		g.setColor(Color.white);
		g.fillRect(640, 450, 75, 20);
		//**********************
		g.setColor(Color.white);
		g.fillRect(450, 230, 70, 20);
		
		g.setColor(Color.red);
		g.fillRect(520, 230, 60, 20);
		
		g.setColor(Color.white);
		g.fillRect(580, 230, 60, 20);
		
		g.setColor(Color.red);
		g.fillRect(640, 230, 75, 20);
		
		
		
		//
		g.setColor(Color.white);
		g.fillRect(100, 340, 60, 20);

		/* passage du pieton */
		g.setColor(Color.white);
		g.fillRect(190, 420, 60, 20);

		g.setColor(Color.white);
		g.fillRect(190, 380, 60, 20);

		g.setColor(Color.white);
		g.fillRect(190, 340, 60, 20);

		g.setColor(Color.white);
		g.fillRect(190, 300, 60, 20);

		g.setColor(Color.white);
		g.fillRect(190, 260, 60, 20);

		/* FIN PASSAGE */

		/* passage du pieton */
		g.setColor(Color.white);
		g.fillRect(450, 420, 60, 20);

		g.setColor(Color.white);
		g.fillRect(450, 380, 60, 20);

		g.setColor(Color.white);
		g.fillRect(450, 340, 60, 20);

		g.setColor(Color.white);
		g.fillRect(450, 300, 60, 20);

		g.setColor(Color.white);
		g.fillRect(450, 260, 60, 20);

		/* FIN PASSAGE */
		g.setColor(Color.white);
		g.fillRect(540, 340, 60, 20);

		g.setColor(Color.white);
		g.fillRect(630, 340, 60, 20);
		/* fin route */

		/* route verticale */
		g.setColor(Color.darkGray);
		g.fillRect(250, 0, 200, 730);

		g.setColor(Color.white);
		g.fillRect(340, 10, 20, 60);

		g.setColor(Color.white);
		g.fillRect(340, 100, 20, 60);

		/* passage du pieton */
		g.setColor(Color.white);
		g.fillRect(420, 190, 20, 60);

		g.setColor(Color.white);
		g.fillRect(380, 190, 20, 60);

		g.setColor(Color.white);
		g.fillRect(340, 190, 20, 60);

		g.setColor(Color.white);
		g.fillRect(300, 190, 20, 60);

		g.setColor(Color.white);
		g.fillRect(260, 190, 20, 60);

		/* FIN PASSAGE */

		/* passage du pieton */
		g.setColor(Color.white);
		g.fillRect(420, 450, 20, 60);

		g.setColor(Color.white);
		g.fillRect(380, 450, 20, 60);

		g.setColor(Color.white);
		g.fillRect(340, 450, 20, 60);

		g.setColor(Color.white);
		g.fillRect(300, 450, 20, 60);

		g.setColor(Color.white);
		g.fillRect(260, 450, 20, 60);

		/* FIN PASSAGE */
		g.setColor(Color.white);
		g.fillRect(340, 540, 20, 60);

		g.setColor(Color.white);
		g.fillRect(340, 630, 20, 60);
		/* fin route */

//		 for (int i = 0; i < f.size(); i++) {
//		 g.setColor(f.get(i).getClr());
//		 g.fillOval(f.get(i).getX(), f.get(i).getY(), 30, 30);
//		 }
//
//		 for (Vehicule vv : v) {
//		 g.setColor(vv.getClr());
//		 g.fillRect(vv.getX(), vv.getY(), 70, 70); // taille de la voiture
//
//		g.drawImage(img, vv.getX(), vv.getY(), Observer);

		
		try {
			img = ImageIO.read(new File("timg.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		g.drawImage(img, v.get(1).getX(), v.get(1).getY(), null);
		
		try {
			img = ImageIO.read(new File("timg (1).png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		g.drawImage(img, v.get(2).getX(), v.get(2).getY(), null);

		try {
			img = ImageIO.read(new File("timg (2).png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		g.drawImage(img, v.get(3).getX(), v.get(3).getY(), null);

		try {
			img = ImageIO.read(new File("img.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		g.drawImage(img, v.get(0).getX(), v.get(0).getY(), null);

	}

	// }

	// public void setFeu(Vector<Feu> f1) {
	// f = f1;
	// }

	public void setVehicule(Vector<Vehicule> v1) {
		v = v1;
	}
}