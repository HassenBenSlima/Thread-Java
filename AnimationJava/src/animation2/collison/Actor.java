package animation2.collison;

import java.awt.Image;

public class Actor {

	private Image img;
	private int x, y, width, height;
	private final int RIGTH = 1, LEFT = -1;
	private byte direction = RIGTH;

	public Actor(Image img, int x, int y, int width, int height) {
		this.img = img;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}

	public void setImg(Image img) {
		this.img = img;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public void setHeight(int height) {
		this.height = height;
	}
	

	public Image getImg() {
		return img;
	}

	

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public int getRIGTH() {
		return RIGTH;
	}

	public int getLEFT() {
		return LEFT;
	}

	public byte getDirection() {
		return direction;
	}

	public void movement(int frameWidth) {
		setX(getX()+direction);
		if(getX()<0) direction=RIGTH;
		if(getX()>(frameWidth-width)) direction=LEFT;
			
	}

}
