package turtle;

import java.beans.PropertyChangeSupport;

import model.Position;

public class Turtle {
	
	private PropertyChangeSupport changes = new PropertyChangeSupport(this);
	
	/* The turtle's current position */
	private Position myPosition;
	private double myHeading; // use unit circle-style direction
	
	/* Current status */
	private boolean myPenDown;
	private boolean myTurtleVisible;
	
	public Turtle() {
		myPosition = new Position(0, 0);
		myHeading = 0;
		myPenDown = true;
		myTurtleVisible = true;
	}

	
	
	//
	//
	/* Getter and Setter methods */
	//
	public Position getPosition() {
		return myPosition;
	}

	public void setPosition(Position position) {
		myPosition = position;
	}
	
	public double getHeading() {
		return myHeading;
	}

	public void setHeading(double heading) {
		myHeading = heading;
	}
	
	public boolean getPenDownStatus() {
		return myPenDown;
	}
	
	public void setPenDownStatus(boolean isPenDown) {
		myPenDown = isPenDown;
	}
	
	
	public boolean getVisibility() {
		return myTurtleVisible;
	}
	
	public void setVisibility(boolean isVisible) {
		myTurtleVisible = isVisible;
	}
	
}
