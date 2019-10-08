import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class TestPhilo extends JFrame implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ImagePanel ip;
	public TestPhilo(){
		this.setContentPane(new PhiloPanel());
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		pack();
		setVisible(true);
	}
	public static void main(String a[]){
		new TestPhilo();
	}

	public void actionPerformed(ActionEvent e) {
		ip.setDroite();	
		
	}
}