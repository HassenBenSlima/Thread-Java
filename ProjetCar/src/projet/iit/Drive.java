package projet.iit;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Drive extends JFrame implements Runnable {

	private Car c1;
	private Car c2;
	private Car c3;
	private Car c4;
	static Graphics g;
	//private DesignProject design = new DesignProject();

	private Road[] roads;
	private Thread thread;
    private JPanel pg1;
	public Drive() {
super("hassen",g);
		c1 = new Car(22, 60, 20, 60);
		c2 = new Car(300, 400, 20, 60);
		c3 = new Car(100, 200, 20, 60);
		c4 = new Car(200, 200, 20, 60);
		
		//getContentPane().

		this.setBackground(Color.GRAY);
		setSize(630,660);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		
//		 pg1= new JPanel();
//		pg1.setBorder(new EmptyBorder(5,5,5,5));
//		pg1.setSize(150,150);
//	pg1.setBackground(Color.ORANGE);
//		pg1.setLocation(150,150);
//		this.getContentPane().setLayout(null);
//		add(pg1);
//		setVisible(true);
//		

	}

	@Override
	public void paint(Graphics g) {

		g.setColor(Color.RED);
		g.fillRect(c1.getX(), c1.getY(), c1.getWidth(), c1.getHeight());

		g.setColor(Color.BLUE);
		g.fillRect(c2.getX(), c2.getY(), c2.getWidth(), c2.getHeight());

		g.setColor(Color.ORANGE);
		g.fillRect(c3.getX(), c3.getY(), c3.getWidth(), c3.getHeight());

		g.setColor(Color.darkGray);
		g.fillRect(c4.getX(), c4.getY(), c4.getWidth(), c4.getHeight());

		// rectangle
		g.setColor(Color.GREEN);
		g.fillRect(110, 140, 150, 150);

		g.setColor(Color.GREEN);
		g.fillRect(370, 140, 150, 150);

		g.setColor(Color.GREEN);
		g.fillRect(110, 400, 150, 150);

		g.setColor(Color.GREEN);
		g.fillRect(370, 400, 150, 150);

		// VERTICAL
		g.setColor(Color.GRAY);
		g.fillRect(50, 140, 10, 150);

		g.setColor(Color.GRAY);
		g.fillRect(50, 400, 10, 150);

		g.setColor(Color.GRAY);
		g.fillRect(310, 140, 10, 150);

		g.setColor(Color.GRAY);
		g.fillRect(310, 400, 10, 150);

		g.setColor(Color.GRAY);
		g.fillRect(570, 140, 10, 150);

		g.setColor(Color.GRAY);
		g.fillRect(570, 400, 10, 150);

		// HORIZONTAL
		g.setColor(Color.GRAY);
		g.fillRect(110, 80, 150, 10);

		g.setColor(Color.GRAY);
		g.fillRect(370, 80, 150, 10);

		g.setColor(Color.GRAY);
		g.fillRect(110, 340, 150, 10);

		g.setColor(Color.GRAY);
		g.fillRect(370, 340, 150, 10);

		g.setColor(Color.GRAY);
		g.fillRect(110, 600, 150, 10);

		g.setColor(Color.GRAY);
		g.fillRect(370, 600, 150, 10);

	}

	@Override
	public void run() {
		

	}

}