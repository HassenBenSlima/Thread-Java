//Action Listener for animation 
public class Car {
	private int x;
	private int y;
	private int width;
	private int height;
	private int velX;
	private int velY;
	private int direction;

	public Car(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.velX = 4;
		this.velY = 4;
	}

	public void up() {
		setVelY(-getVelY());
	}

	public void down() {
		setVelY(getVelY());
	}

	public void left() {
		setVelX(-getVelX());
	}

	public void right() {
		setVelX(getVelX());
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

	public void tick() {
		x += 1;
	}

	public void movement() {
		setX(getX() + getVelX());

	}

	public static void move(int width, int height, Car car) {
		if (car.getX() < 0) {
			car.setVelY(0);
			car.setX(0);

		}
		if (car.getX() > width) {
			car.setX(0);
			car.setVelX(0);
		}

		if (car.getY() < 0) {
			car.setVelY(0);
			car.setY(0);
		}
		if (car.getY() > height) {
			car.setVelY(0);
			car.setVelY(height);
		}

		// x = x + vitesseX;
		// y = y + vitesseY;
		// repaint();

		if (car.getX() < 0 || car.getX() > width)
			car.setVelX(-car.getVelX());
		car.setX(car.getX() + car.getVelX());
		// repaint();// repaint the rectangle every 5 ms

	}

}
