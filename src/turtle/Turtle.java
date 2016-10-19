package turtle;

import java.beans.PropertyChangeSupport;
import java.util.Observable;

public class Turtle extends Observable{
	
	private PropertyChangeSupport changes = new PropertyChangeSupport(this);
	
	/* The turtle's current position */
	private Position myPosition;
	private double myHeading; // use unit circle-style direction
	
	/* Current status */
	private boolean myPenDown;
	private boolean myTurtleVisible;
	
	public Turtle() {
//		addObserver(aClassThatIsObserving); TODO: implement observer
		myPosition = new Position(0, 0);
		myHeading = 0;
		myPenDown = true;
		myTurtleVisible = true;
	}

	private void updateAndCallObserver() {
        setChanged();
        TurtleState showOffState = new TurtleState(myPosition, myHeading, myPenDown, myTurtleVisible);
        notifyObservers(showOffState);
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
        updateAndCallObserver();
	}
	
	public double getHeading() {
		return myHeading;
	}

	public void setHeading(double heading) {
		myHeading = heading;
        updateAndCallObserver();
	}
	
	public boolean getPenDownStatus() {
		return myPenDown;
	}
	
	public void setPenDownStatus(boolean isPenDown) {
		myPenDown = isPenDown;
        updateAndCallObserver();
	}

	public boolean getVisibility() {
		return myTurtleVisible;
	}
	
	public void setVisibility(boolean isVisible) {
		myTurtleVisible = isVisible;
        updateAndCallObserver();
	}
	
}
