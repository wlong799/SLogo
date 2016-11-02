package dataStorage;

import java.beans.PropertyChangeSupport;
import java.util.Observable;


public class Turtle extends Observable implements TurtleState {

    private PropertyChangeSupport changes = new PropertyChangeSupport(this);

    /* The dataStorage's current position */
    private int myID;

    /* The Turtle's current position */
    private Position myPosition;
    private double myHeading; // use unit circle-style direction

    /* Pen status */
    private boolean myPenDown;
    private String myPenColor;
    private double myPenSize;
    private int myColorIndex;

    /* Turtle status */
    private boolean myTurtleVisible;
    private double myShape;

    public Turtle (int id) {
        myID = id;
        myPosition = new Position(0, 0);
        myHeading = -90.0;
        myPenDown = true;
        myTurtleVisible = true;
        myPenColor = "rgb(255,0,0)";
        myColorIndex = 0;
        
    }
    
    private Turtle(Turtle t){
        myID = t.myID;
        myPosition = t.myPosition;
        myHeading = t.myHeading;
        myPenDown = t.myPenDown;
        myTurtleVisible = t.myTurtleVisible;
        myPenColor = t.myPenColor;
        myColorIndex = t.myColorIndex;
    }
    private void updateAndCallObserver () {
        setChanged();
        notifyObservers(new Turtle(this));
    }

    //
    /* Getter and Setter methods */
    //

    public int getID () {
        return myID;
    }

    public Position getPosition () {
        return myPosition;
    }

    public void setPosition (Position position) {
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

    public String getPenColor () {
        return myPenColor;
    }

    public int getColorIndex () {
        return myColorIndex;
    }

    public void setColorIndex (int index) {
        myColorIndex = index;
    }

    public void setPenColor (String newPenColor) {
        myPenColor = newPenColor;
        updateAndCallObserver();
    }

    public double getPenSize () {
        return myPenSize;
    }

    public void setPenSize (double newPenSize) {
        myPenSize = newPenSize;
    }

    public boolean getVisibility () {
        return myTurtleVisible;
    }

    public void setVisibility (boolean isVisible) {
        myTurtleVisible = isVisible;
        updateAndCallObserver();
    }

    public void setShape (double newShape) {
        myShape = newShape;
    }

    public double getShape () {
        return myShape;
    }
}
