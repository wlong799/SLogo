package dataStorage;

/**
 * TurtleState is a simplified object which only reflects what the Turtle has
 * but without any of the dataStorage's functionality
 *
 * @author Filip Mazurek
 */
public class TurtleState {
    private int myID;
    private Position myPosition;
    private double myHeading;
    private boolean myPenDown;
    private boolean myTurtleVisible;

    public TurtleState(Turtle t) {
        myID = t.getID();
        myPosition = t.getPosition();
        myHeading = t.getHeading();
        myPenDown = t.getPenDownStatus();
        myTurtleVisible = t.getVisibility();
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

    public boolean getVisibility() {
        return myTurtleVisible;
    }

}

