package animation.Cloud;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class MoveImage extends JFrame implements Runnable {

	private int frameWidh = 700, frameHeight = 500;
	private Image cloud = new ImageIcon("/home/hassen/Documents/gamePicture/carRigth.png").getImage();
	private Image sun = new ImageIcon("/home/hassen/Documents/gamePicture/carUp.png").getImage();
	private Thread thread;
	private int cloudx = 100;

	public MoveImage() {
		setBounds(100, 100, frameWidh, frameHeight);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		thread = new Thread(this);
		thread.start();
	}

	public void paint(Graphics g) {
		g.setColor(Color.black);
		g.fillRect(0, 0, frameWidh, frameHeight);

		g.setColor(Color.white);
		g.fillRect(30, 40, 100, 50);

		g.setColor(Color.cyan);
		g.fillRect(150, 150, 200, 200);

		g.drawImage(cloud, cloudx, 150, null);
		g.drawImage(sun, 100, 150, null);
	}

	public static void main(String[] args) {
		new MoveImage();
	}

	@Override
	public void run() {

		while (true) {
			cloudx++;
			repaint();
			try {
				thread.sleep(200);
			} catch (InterruptedException e) {
				System.out.println("Error in executing thread:" + e);
			}
		}
	}

}
