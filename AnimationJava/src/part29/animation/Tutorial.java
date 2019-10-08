package part29.animation;

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
		setSize(960, 960);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);// fermer le programme avec le clique sur x
	}

	@Override
	public void paint(Graphics g) {
		super.paintComponents(g);
		
			g.drawLine(0, 480,960, 480);
	
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
