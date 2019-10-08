package projet.iit;

import java.awt.Rectangle;

public class RoundPoint {
	
	private Rectangle rectangle;
	private Boolean active;
	
	public RoundPoint(Rectangle rectangle, Boolean active) {
		this.rectangle = rectangle;
		this.active = active;
	}
	public Rectangle getRectangle() {
		return rectangle;
	}
	public void setRectangle(Rectangle rectangle) {
		this.rectangle = rectangle;
	}
	public Boolean getActive() {
		return active;
	}
	public void setActive(Boolean active) {
		this.active = active;
	}
	
	
	
	
	
	
}
