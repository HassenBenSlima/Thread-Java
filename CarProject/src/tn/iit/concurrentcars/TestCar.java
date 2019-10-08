package tn.iit.concurrentcars;

public class TestCar {

	public static void main(String[] args) {
		Frame frame = new Frame();
		frame.setVisible(true);
		frame.setResizable(false);
		Road road = new Road();
		road.createRectInTheRoundPoint();
		road.createRoundPoints();
		Car car1 = new Car(150, 337, 20, 20);
		Car car2 = new Car(400, 337, 20, 20);
	
		// Car car3 = new Car(482, 25, 30, 30);
		// Car car4 = new Car(337, 150, 20, 20);
		// Car car5 = new Car(537, 150, 60, 20);
		// Car car6 = new Car(597, 150, 60, 20);
		
		frame.getContentPane().add(car1);
		frame.getContentPane().add(car2);
		// frame.getContentPane().add(car3);
		// frame.getContentPane().add(car4);
		// // frame.getContentPane().add(car5);
		// frame.getContentPane().add(car6);

	}

}
