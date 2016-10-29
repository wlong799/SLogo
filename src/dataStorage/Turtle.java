package dataStorage;

import java.beans.PropertyChangeSupport;
import java.util.Observable;

public class Turtle extends Observable{

	private PropertyChangeSupport changes = new PropertyChangeSupport(this);

    private int myID;

	/* The Turtle's current position */
	private Position myPosition;
	private double myHeading; // use unit circle-style direction

	/* Pen status */
	private boolean myPenDown;
    private double myPenColor;
    private double myPenSize;

    /* Turtle status */
	private boolean myTurtleVisible;
    private double myShape;


	public Turtle(int id) {
        myID = id;
		myPosition = new Position(0, 0);
		myHeading = -90.0;
		myPenDown = true;
		myTurtleVisible = true;
	}

	private void updateAndCallObserver() {
        TurtleState showOffState = new TurtleState(myPosition, myHeading, myPenDown, myTurtleVisible);

        setChanged();
        notifyObservers(showOffState);
        // clearChanged(); // TODO: Was this removed on purpose?
        // this was removed because notifyObservers automatically clears changed
    }


	//
	/* Getter and Setter methods */
	//

    public double getID() {
        return myID;
    }

	public Position getPosition() {
		return myPosition;
	}

	public void setPosition(Position position) {
		myPosition = position;
        updateAndCallObserver();
    }

    public double getHeading () {
        return myHeading;
    }

    public void setHeading (double heading) {
        myHeading = heading;
        updateAndCallObserver();
    }

    public boolean getPenDownStatus () {
        return myPenDown;
    }

    public void setPenDownStatus (boolean isPenDown) {
        myPenDown = isPenDown;
        updateAndCallObserver();
	}

    public double getPenColor() {
        return myPenColor;
    }

    public void setPenColor(double newPenColor) {
        myPenColor = newPenColor;
    }

    public double getPenSize() {
        return myPenSize;
    }

    public void setPenSize(double newPenSize) {
        myPenSize = newPenSize;
    }

	public boolean getVisibility() {
		return myTurtleVisible;
	}

	public void setVisibility(boolean isVisible) {
		myTurtleVisible = isVisible;
        updateAndCallObserver();
	}

    public void setShape(double newShape) {
        myShape = newShape;
    }

    public double getShape() {
        return myShape;
    }
}
