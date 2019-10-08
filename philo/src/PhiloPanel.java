
/**
 * 
 *
 *

 */

import java.awt.BorderLayout;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
public class PhiloPanel extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Semaphore s[];
	private Philo p[];
    public PhiloPanel() {
    	setLayout(new BorderLayout());
    	add(new JLabel(new ImageIcon("images\\couscous.jpg")),BorderLayout.CENTER);
    	
		p = new Philo[10];
    	s = new Semaphore[10];
    	for (int i = 0; i<10; i++)s[i]= new Semaphore(1);
    	p[0]=new Philo(1,s[9],s[0]);
    	for (int i = 1; i<10; i++)p[i]=new Philo(i+1,s[i-1],s[i]);
  		int cp = 0;
     	JPanel j = new JPanel();
 		for (int i = 0; i<3; i++){
			for (int jj = 0; jj<3; jj++){
  				j.add(p[cp++].getPanel());
  			}
  			switch (i) {
			case 0:add(j,BorderLayout.NORTH); break;
			case 1:add(j,BorderLayout.EAST); break;
			case 2:add(j,BorderLayout.WEST); break;
			}
  		j = new JPanel();
  		j.setLayout(new BoxLayout(j,BoxLayout.Y_AXIS));
  		}
  		for (int i = 0; i<10; i++)p[i].start();
    }
    
    
}