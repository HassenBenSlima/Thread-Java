package tn.iit.concurrentcars;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Frame extends JFrame {
	private static final long serialVersionUID = 1L;

	public Frame() {
		super();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setBounds(100, 100, 450, 300);
		this.getContentPane().setLayout(null);
		this.getContentPane().setBackground(Color.GRAY);
		this.setSize(630, 660);

		JPanel p1 = new JPanel();
		p1.setBorder(new EmptyBorder(5, 5, 5, 5));
		p1.setLayout(new BorderLayout(0, 0));
		p1.setSize(150, 150);
		p1.setBackground(Color.GREEN);
		p1.setLocation(110, 110);
		this.getContentPane().setLayout(null);
		this.getContentPane().add(p1);

		JPanel p2 = new JPanel();
		p2.setBorder(new EmptyBorder(5, 5, 5, 5));
		p2.setLayout(new BorderLayout(0, 0));
		p2.setSize(150, 150);
		p2.setBackground(Color.GREEN);
		p2.setLocation(370, 110);
		this.getContentPane().setLayout(null);
		this.getContentPane().add(p2);

		JPanel p3 = new JPanel();
		p3.setBorder(new EmptyBorder(5, 5, 5, 5));
		p3.setLayout(new BorderLayout(0, 0));
		p3.setSize(150, 150);
		p3.setBackground(Color.GREEN);
		p3.setLocation(110, 370);
		this.getContentPane().setLayout(null);
		this.getContentPane().add(p3);

		JPanel P4 = new JPanel();
		P4.setBorder(new EmptyBorder(5, 5, 5, 5));
		P4.setLayout(new BorderLayout(0, 0));
		P4.setSize(150, 150);
		P4.setBackground(Color.GREEN);
		P4.setLocation(370, 370);
		this.getContentPane().setLayout(null);
		this.getContentPane().add(P4);

	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);

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
}
