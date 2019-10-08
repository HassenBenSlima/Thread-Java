import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Design extends JFrame implements Runnable {

	private JPanel contentPane;
	private Car c1;
	private Car c2;
	private Car c3;
	private Car c4;
	private Car c5;
	private static Thread thread;
	JPanel car;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Design frame = new Design();
					frame.setSize(630, 670);
					frame.setResizable(false);
					frame.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Design() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(5, 5));
		contentPane.setBackground(Color.GRAY);
		setContentPane(contentPane);

		JPanel pg1 = new JPanel();
		pg1.setBorder(new EmptyBorder(5, 5, 5, 5));
		pg1.setSize(150, 150);
		pg1.setBackground(Color.GREEN);
		pg1.setLocation(110, 110);
		this.getContentPane().setLayout(null);
		add(pg1);

		JPanel pg2 = new JPanel();
		pg2.setBorder(new EmptyBorder(5, 5, 5, 5));
		pg2.setSize(150, 150);
		pg2.setBackground(Color.GREEN);
		pg2.setLocation(370, 110);
		this.getContentPane().setLayout(null);
		add(pg2);

		JPanel pg3 = new JPanel();
		pg3.setBorder(new EmptyBorder(5, 5, 5, 5));
		pg3.setSize(150, 150);
		pg3.setBackground(Color.GREEN);
		pg3.setLocation(110, 370);
		this.getContentPane().setLayout(null);
		add(pg3);

		JPanel pg4 = new JPanel();
		pg4.setBorder(new EmptyBorder(5, 5, 5, 5));
		pg4.setSize(150, 150);
		pg4.setBackground(Color.GREEN);
		pg4.setLocation(370, 370);
		this.getContentPane().setLayout(null);
		add(pg4);

		c1 = new Car(20, 30, 60, 20);

		car = new JPanel();
		car.setBorder(new EmptyBorder(5, 5, 5, 5));
		car.setSize(c1.getWidth(), c1.getHeight());
		car.setBackground(Color.GREEN);
		car.setLocation(c1.getX(), c1.getY());
		this.getContentPane().setLayout(null);
		add(car);

		thread = new Thread(this);
		thread.start();
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);

		g.setColor(Color.BLUE);
		g.fillRect(c1.getX(), c1.getY(), c1.getWidth(), c1.getHeight());

		// VERTICAL
		g.setColor(Color.WHITE);
		g.fillRect(50, 140, 10, 150);

		g.setColor(Color.WHITE);
		g.fillRect(50, 400, 10, 150);

		g.setColor(Color.WHITE);
		g.fillRect(310, 140, 10, 150);

		g.setColor(Color.WHITE);
		g.fillRect(310, 400, 10, 150);

		g.setColor(Color.WHITE);
		g.fillRect(570, 140, 10, 150);

		g.setColor(Color.WHITE);
		g.fillRect(570, 400, 10, 150);

		// HORIZONTAL
		g.setColor(Color.WHITE);
		g.fillRect(110, 80, 150, 10);

		g.setColor(Color.WHITE);
		g.fillRect(370, 80, 150, 10);

		g.setColor(Color.WHITE);
		g.fillRect(110, 340, 150, 10);

		g.setColor(Color.WHITE);
		g.fillRect(370, 340, 150, 10);

		g.setColor(Color.WHITE);
		g.fillRect(110, 600, 150, 10);

		g.setColor(Color.WHITE);
		g.fillRect(370, 600, 150, 10);

	}

	@Override
	public void run() {

		while (true) {
			c1.movement();
			// car.repaint();
			Car.move(630, 670, c1);
			repaint();
			System.out.println(c1.getX());

			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				System.out.println("Error in executing thread:" + e);
			}
		}
	}

}
