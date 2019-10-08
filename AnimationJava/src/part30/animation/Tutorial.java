package part30.animation;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JPanel;



//Action Listener for animation 
public class Tutorial extends JFrame {

	private static final long serialVersionUID = 1L;

	JLabel jl;
	JButton jb;
	JPanel jp,jp2;
	
	public Tutorial() {
		setTitle("Tutorial");
		setSize(960, 960);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		jp=new JPanel();
		jp2=new JPanel();

		jl=new JLabel("This is a message");
		jp.add(jl);
		add(jp);

		
		jb=new JButton("Press Me");
		jp2.add(jb);
		
		add(jp2,BorderLayout.SOUTH);

		
	}

	
	public static void main(String[] args) {
		try {
			Tutorial t = new Tutorial();
		} catch (Exception e) {
		}
	}

}
