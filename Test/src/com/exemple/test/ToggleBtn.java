package com.exemple.test;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ToggleBtn extends JPanel {
	private static final long serialVersionUID = 1L;

	JFrame frame;
	JPanel panelOut;
	JLabel labelOn;
	JLabel labelOff;
	JButton btn;
	int count = 1;

	public ToggleBtn() {
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(500, 300, 300, 300);
		frame.setLayout(null);

		panelOut = new JPanel(null);
		panelOut.setBounds(50, 100, 120, 30);
		panelOut.setBackground(Color.gray);
		frame.add(panelOut);

		btn = new JButton("::");
		btn.setBounds(0, 0, 60, 30);
		panelOut.add(btn);
		btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				startThread();
			}
		});
		labelOn = new JLabel("ON");
		labelOn.setBounds(0, 0, 60, 30);
		panelOut.add(labelOn);

		labelOff = new JLabel("OFF");
		labelOff.setBounds(60, 0, 60, 30);
		panelOut.add(labelOff);

		frame.setVisible(true);
	}

	public void startThread() {
		count++;
		new Move().start();
	}

	public static void main(String[] args) {
		new ToggleBtn();
	}

	class Move extends Thread {

		@Override
		public void run() {
			if (count % 2 == 0) {
				System.out.println("if");
				for (int i = 0; i <= 60; i++) {
					try {
						Thread.sleep(3);
					} catch (InterruptedException ex) {
						Logger.getLogger(ToggleBtn.class.getName()).log(Level.SEVERE, null, ex);
					}
					btn.setBounds(i, 0, 60, 30);
				}

			} else {
				System.out.println("else");
				for (int i = 60; i >= 0; i--) {
					try {
						Thread.sleep(3);
					} catch (InterruptedException ex) {
						Logger.getLogger(ToggleBtn.class.getName()).log(Level.SEVERE, null, ex);
					}
					btn.setBounds(i, 0, 60, 30);
				}
			}
		}
	}
}