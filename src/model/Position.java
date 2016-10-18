package model;

public class Position {
	private double myX;
	private double myY;
	
	public Position(double x, double y) {
		myX = x;
		myY = y;
	}
	
//	public Postiion() {
//		Position(0,0);
//	}
	

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
