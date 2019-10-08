package com.exemple.test;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Exemple {

	public static void main(String[] args) {


JFrame frame = new JFrame ("Compass");
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.getContentPane().setLayout(new GridLayout(3, 3));
frame.add (new JButton("NW"));
frame.add (new JButton ("N"));
frame.add (new JButton ("NE"));
frame.add (new JButton ("W"));
frame.add (new JButton (" "));
frame.add (new JButton ("E"));
frame.add (new JButton ("SW"));
frame.add (new JButton ("S"));
//frame.add (new JButton ("SE"));
frame.pack();
frame.setVisible(true);


	}

}
