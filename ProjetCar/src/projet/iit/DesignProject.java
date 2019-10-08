package projet.iit;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class DesignProject extends JPanel {
	
	public  DesignProject() {
		
		this.setSize(630, 660);
		this.setBackground(Color.green);
	}
	
	@Override
	public void paint(Graphics g) {
				//rectangle
				g.setColor(Color.GREEN);
				g.fillRect(110, 140, 150, 150);

				g.setColor(Color.GREEN);
				g.fillRect(370, 140, 150, 150);

				g.setColor(Color.GREEN);
				g.fillRect(110, 400, 150, 150);

				g.setColor(Color.GREEN);
				g.fillRect(370, 400, 150, 150);
			
				//VERTICAL
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
	
	
	
}
