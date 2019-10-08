package tn.iit.concurrentcars;

import java.util.ArrayList;
import java.util.concurrent.Semaphore;

public class RoundPoint {

	private Semaphore next1;
	private Point inRigth;
	private Point inLeft;
	private Point inUp;
	private Point inDown;
	private ArrayList<Car> carsOfRoundPoint;
	private InTheRoundPoint irp;

	public RoundPoint(Point inRigth, Point inUp, Point inLeft, Point inDown, InTheRoundPoint irInTheRoundPoint) {
		this.inRigth = inRigth;
		this.inLeft = inLeft;
		this.inUp = inUp;
		this.inDown = inDown;
		this.irp = irInTheRoundPoint;

		next1 = new Semaphore(1, true);

		carsOfRoundPoint = new ArrayList<Car>();
	}

	public InTheRoundPoint getIrp() {
		return irp;
	}

	public void setIrp(InTheRoundPoint irp) {
		this.irp = irp;
	}

	public ArrayList<Car> getCarsOfRoundPoint() {
		return carsOfRoundPoint;
	}

	public void setCarsOfRoundPoint(ArrayList<Car> carsOfRoundPoint) {
		this.carsOfRoundPoint = carsOfRoundPoint;
	}

	public Semaphore getNext1() {
		return next1;
	}

	public void setNext1(Semaphore next1) {
		this.next1 = next1;
	}

	public Point getInRigth() {
		return inRigth;
	}

	public void setInRigth(Point inRigth) {
		this.inRigth = inRigth;
	}

	public Point getInLeft() {
		return inLeft;
	}

	public void setInLeft(Point inLeft) {
		this.inLeft = inLeft;
	}

	public Point getInUp() {
		return inUp;
	}

	public void setInUp(Point inUp) {
		this.inUp = inUp;
	}

	public Point getInDown() {
		return inDown;
	}

	public void setInDown(Point inDown) {
		this.inDown = inDown;
	}

}
