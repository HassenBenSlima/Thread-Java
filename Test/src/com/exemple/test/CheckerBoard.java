package com.exemple.test;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.GridLayout;
import java.awt.Color;

public class CheckerBoard extends JFrame{
	private static final long serialVersionUID = 1L;

public static void main(String[] args){
   boolean whatColor = true;
   JButton btnBoard = new JButton();
   JFrame menu = new JFrame("Checkerboard");
   menu.setLayout(new GridLayout(8,8));
   for (int i = 0; i < 64; i++){
     if (whatColor){
       btnBoard.setBackground(Color.WHITE);
       menu.add(btnBoard);
       whatColor = !whatColor;
     }else{
        btnBoard.setBackground(Color.BLACK);
       menu.add(btnBoard);
       whatColor = !whatColor;       
     }
   }
    
    menu.pack();
    menu.setLocationRelativeTo(null);
    menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    menu.setVisible(true);
  }
  
  
  
}
