package projet.iit;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

//Action Listener for animation 
public class Road extends JPanel {

	private int startPoint;
	private int endPoint;
	private boolean active;

	public Road(int startPoint, int endPoint, boolean active) {
		this.startPoint = startPoint;
		this.endPoint = endPoint;
		this.active = active;
	}

	public int getStartPoint() {
		return startPoint;
	}

	public void setStartPoint(int startPoint) {
		this.startPoint = startPoint;
	}

	public int getEndPoint() {
		return endPoint;
	}

	public void setEndPoint(int endPoint) {
		this.endPoint = endPoint;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
	


}
