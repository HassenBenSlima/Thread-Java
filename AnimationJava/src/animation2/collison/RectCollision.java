package animation2.collison;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class RectCollision extends JFrame implements Runnable {

	private int frameWidth = 700, frameHeight = 500;
	private Image gCarImg = new ImageIcon("/home/hassen/Documents/gamePicture/carRigth.png").getImage();
	private Image pCarImg = new ImageIcon("/home/hassen/Documents/gamePicture/carLeft.png").getImage();
	private Thread thread;
	private Actor greenCar, pinkCar;
	private Font font;

	public RectCollision() {
		setBounds(100, 100, frameWidth, frameHeight);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		thread = new Thread(this);
		thread.start();
		greenCar = new Actor(gCarImg, 30, 70, 98, 40);// 98 and 40 are width and height of car image
		pinkCar = new Actor(pCarImg, 400, 70, 98, 40);
		font = new Font("Comic Sans MS", Font.BOLD, 25);
	}

	public void paint(Graphics g) {
		g.setColor(Color.white);
		g.fillRect(0, 0, frameWidth, frameHeight);

		g.drawImage(greenCar.getImg(), greenCar.getX(), greenCar.getY(), null);
		g.drawImage(pinkCar.getImg(), pinkCar.getX(), pinkCar.getY(), null);
		
		g.setColor(Color.BLACK);
		g.setFont(font);
		g.drawString("Collided: "+boxCollision(greenCar, pinkCar),200,400);
	}

	@Override
	public void run() {

		while (true) {
			pinkCar.movement(frameWidth);
			greenCar.movement(frameWidth);

			repaint();
			try {
				thread.sleep(200);// increase the animation speed
			} catch (InterruptedException e) {
				System.out.println("Error in executing thread:" + e);
			}
		}
	}

	private boolean boxCollision(Actor rect1, Actor rect2) {
			if (rect1.getX() < rect2.getX() + rect2.getWidth() &&
				rect1.getX() + rect1.getWidth() > rect2.getX() &&
				rect1.getY() < rect2.getY() + rect2.getHeight() && 
				rect1.getHeight() + rect1.getY() > rect2.getY())
			return true;
		return false;

	}

	public static void main(String[] args) {
		new RectCollision();
	}

}
