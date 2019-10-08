package projet.iit;

import javax.swing.ImageIcon;

//Action Listener for animation 
public class Car  {
	private int x;
	private int y;
	private int width;
	private int height;
	private int velX;
	private int velY;
	

	
	public Car(int x, int y, int width, int height) {
		super();
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.velX = 0;
		this.velY = 0;
	}


	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getVelX() {
		return velX;
	}

	public void setVelX(int velX) {
		this.velX = velX;
	}

	public int getVelY() {
		return velY;
	}

	public void setVelY(int velY) {
		this.velY = velY;
	}


	public void marcheVoiture() {
		for (int i = 0; i < 200; i++)
			x = x + i;
	}

	

	// public void paint(Graphics g) {
	//
	// g.drawImage(newimg, x, y, null);
	// }
//	public void turnRigth() {
//		ImageIcon i = new ImageIcon("/home/hassen/Documents/gamePicture/carRigth.png");
//		Image img = i.getImage();
//		Image newimg = img.getScaledInstance(60, 20, java.awt.Image.SCALE_SMOOTH);
//		i = new ImageIcon(newimg);
//		setBounds(x, y, 60, 20);
//
//	}
//
//	public void turnLeft() {
//		ImageIcon i = new ImageIcon("/home/hassen/Documents/gamePicture/carLeft.png");
//		Image img = i.getImage();
//		Image newimg = img.getScaledInstance(60, 20, java.awt.Image.SCALE_SMOOTH);
//		i = new ImageIcon(newimg);
//		setBounds(x, y, 60, 20);
//
//	}
//
//	public void turnUp() {
//		ImageIcon i = new ImageIcon("/home/hassen/Documents/gamePicture/carUP.png");
//		Image img = i.getImage();
//		Image newimg = img.getScaledInstance(20, 60, java.awt.Image.SCALE_SMOOTH);
//		i = new ImageIcon(newimg);
//		setBounds(x, y, 20, 60);
//
//	}
//
//	public void turnDown() {
//		ImageIcon i = new ImageIcon("/home/hassen/Documents/gamePicture/carDown.png");
//		Image img = i.getImage();
//		Image newimg = img.getScaledInstance(20, 60, java.awt.Image.SCALE_SMOOTH);
//		i = new ImageIcon(newimg);
//		setBounds(x, y, 20, 60);
//
//	}

	public void guiV() {
		// i = new ImageIcon("/home/hassen/Documents/gamePicture/carDown.png");
		// img = i.getImage();
		// newimg = img.getScaledInstance(20, 60, java.awt.Image.SCALE_SMOOTH);
		// i = new ImageIcon(newimg);

//		setContentAreaFilled(true);
//		setBorder(null);
//		setIcon(i);
//		setVisible(true);
	}

	public void tick() {
		x += 1;
	}

	public void movement() {
		setY(getY()+2);
			
	}
	
	public void move (int width,int height) {
		  if (x < 0) {
		  velX = 0;
		  x = 0;
		  }
		  if (x > width) {
			  velX = 0;
		  x = width;
		  }
		 
		  if (y < 0) {
			  velY = 0;
		  y = 0;
		  }
		  if (y > height) {
			  velY = 0;
		  y = height;
		  }
		 
		 // x = x + vitesseX;
		 // y = y + vitesseY;
		 // repaint();
	
		if (x < 0 || x > width)
		 velX = -velX;
		
		 x = x + velX;
		// repaint();// repaint the rectangle every 5 ms
		
		 }


}
