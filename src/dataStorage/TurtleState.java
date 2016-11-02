package dataStorage;

/**
 * 
 * @author michael
 *
 */
public interface TurtleState {

    int getID ();

    Position getPosition ();

    double getHeading ();

    boolean getPenDownStatus ();

    String getPenColor ();

    int getColorIndex ();

    double getPenSize ();

    boolean getVisibility ();

    double getShape ();

}
