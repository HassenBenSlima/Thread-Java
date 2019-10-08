package tn.iit.concurrentcars;

public class InTheRoundPoint {

	private Point firstPoint;
	private Point secondPoint;
	private Point thirdPoint;
	private Point fourthPoint;
	public Point getFirstPoint() {
		return firstPoint;
	}
	public void setFirstPoint(Point firstPoint) {
		this.firstPoint = firstPoint;
	}
	public Point getSecondPoint() {
		return secondPoint;
	}
	public void setSecondPoint(Point secondPoint) {
		this.secondPoint = secondPoint;
	}
	public Point getThirdPoint() {
		return thirdPoint;
	}
	public void setThirdPoint(Point thirdPoint) {
		this.thirdPoint = thirdPoint;
	}
	public Point getFourthPoint() {
		return fourthPoint;
	}
	public void setFourthPoint(Point fourthPoint) {
		this.fourthPoint = fourthPoint;
	}
	public InTheRoundPoint(Point firstPoint, Point secondPoint, Point thirdPoint, Point fourthPoint) {
		this.firstPoint = firstPoint;
		this.secondPoint = secondPoint;
		this.thirdPoint = thirdPoint;
		this.fourthPoint = fourthPoint;
	}

	
}
