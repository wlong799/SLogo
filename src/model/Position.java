package model;

public class Position {
	private double myX;
	private double myY;
	
	public Position() {
		myX = 0;
		myY = 0;
	}
	
	public Position(double x, double y) {
		myX = x;
		myY = y;
	}

	public double getX() {
		return myX;
	}

	public void setX(double x) {
		myX = x;
	}

	public double getY() {
		return myY;
	}

	public void setY(double y) {
		myY = y;
	}
}
