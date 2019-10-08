import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TestPhilo extends JFrame implements ActionListener{
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