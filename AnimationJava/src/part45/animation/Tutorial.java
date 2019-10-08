package part45.animation;

import java.awt.Color;//TO USE COLOR
import java.awt.Graphics;//we can use paint method
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;// we can use actionPerformed method
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.Timer;
import javax.swing.JFrame;
import javax.swing.JPanel;

//Action Listener for animation 
public class Tutorial extends JPanel implements ActionListener, KeyListener {
	private static final long serialVersionUID = 1L;

	Timer tm = new Timer(5, this);
	int x = 0, y = 0, velX = 0, velY = 0;

	public Tutorial() {
		tm.start();
		addKeyListener(this);
		setFocusable(true);// anable for keyListener
		setFocusTraversalKeysEnabled(false);
	}

	@Override
	public void paint(Graphics g) {
		super.paintComponent(g);

		g.setColor(Color.RED);
		g.fillRect(x, y, 50, 30);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
//		if (x < 0) {
//			velX = 0;
//			x = 0;
//		}
//		if (x > 530) {
//			velX = 0;
//			x = 530;
//		}
//
//		if (y < 0) {
//			velY = 0;
//			y = 0;
//		}
//		if (y > 330) {
//			velY = 0;
//			y = 330;
//		}
//
//		x = x + velX;
//		y = y + velY;
//		repaint();
		if (x < 0 || x > 350)
			velX = -velX;

		x = x + velX;
		repaint();// repaint the rectangle every 5 ms
	
	}

	@Override
	public void keyPressed(KeyEvent e) {// down
		int c = e.getKeyCode();
		if (c == KeyEvent.VK_LEFT) {
			velX = -1;
			velY = 0;
		}

		if (c == KeyEvent.VK_UP) {
			velX = 0;
			velY = -1;
		}
		if (c == KeyEvent.VK_RIGHT) {
			velX = 1;
			velY = 0;
		}

		if (c == KeyEvent.VK_DOWN) {
			velX = 0;
			velY = 1;
		}

	}

	@Override
	public void keyTyped(KeyEvent arg0) {

	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		velX = 0;
		velY = 0;

	}

	public static void main(String[] args) {
		Tutorial t = new Tutorial();
		JFrame jf = new JFrame();
		jf.setTitle("Tutorial");
		jf.setSize(600, 400);
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// fermer le programme avec le clique sur x
		jf.add(t);

	}

}
