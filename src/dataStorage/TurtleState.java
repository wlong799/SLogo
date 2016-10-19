package dataStorage;

/**
 * TurtleState is a simplified object which only reflects what the Turtle has
 * but without any of the dataStorage's functionality
 * 
 * @author Filip Mazurek
 */
class TurtleState {
	private Position myPosition;
	private double myHeading; // use unit circle-style direction
	
	private boolean myPenDown;
	private boolean myTurtleVisible;

	
	public TurtleState(Position position, double heading, boolean isPenDown, boolean isTurtleVisible) {
		myPosition = position;
		myHeading = heading;
		myPenDown = isPenDown;
		myTurtleVisible = isTurtleVisible;
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
	
	public boolean getVisibility() {
		return myTurtleVisible;
	}

}

