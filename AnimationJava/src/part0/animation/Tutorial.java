package part0.animation;

import java.awt.Color;//TO USE COLOR
import java.awt.Graphics;//we can use paint method
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;// we can use actionPerformed method
import javax.swing.Timer;

import javax.swing.JFrame;

//Action Listener for animation 
public class Tutorial extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;

	Timer tm = new Timer(5, this);// it's good to use for animation(5 ms, for Action Listener)
	int x = 0, velX = 2;// x position , velx speed for rectangle

	public Tutorial() {
		setTitle("Tutorial");
		setSize(600, 400);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);// fermer le programme avec le clique sur x
	}

	@Override
	public void paint(Graphics g) {
		super.paintComponents(g);
		g.setColor(Color.RED);
		g.drawRect(480, 480, 200, 100);

		g.setColor(Color.BLUE);
		g.fillRect(x, 240, 200, 100);
		tm.start();

		g.setColor(Color.GREEN);
		g.drawOval(40, 40, 50, 50);
		g.setColor(Color.ORANGE);
		g.fillOval(40, 100, 100, 100);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (x < 0 || x > 350)
			velX = -velX;

		x = x + velX;
		repaint();// repaint the rectangle every 5 ms
	}

	public static void main(String[] args) {
		try {
			Tutorial t = new Tutorial();
			t.paint(null);
		} catch (Exception e) {
		}
	}

}
