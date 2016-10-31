package dataStorage;

/**
 * TurtleState is a simplified object which only reflects what the Turtle has
 * but without any of the dataStorage's functionality
 *
 */
public class TurtleState {
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


	public TurtleState(Turtle t) {
		myID = t.getID();
		myPosition = t.getPosition();
		myHeading = t.getHeading();
		myPenDown = t.getPenDownStatus();
		myPenColor = t.getPenColor();
		myPenSize = t.getPenSize();
		myTurtleVisible = t.getVisibility();
		myShape = t.getShape();
	}

	public int getID() {
		return myID;
	}

    public Position getPosition() {
		return myPosition;
	}

	public double getHeading() {
		return myHeading;
	}
	
	public boolean getPenDownStatus() {
		return myPenDown;
	}

    public double getPenSize() {
        return myPenSize;
    }

	public boolean getVisibility() {
		return myTurtleVisible;
	}

    public double getShape() {
        return myShape;
    }
}