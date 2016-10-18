package turtle;

import java.beans.PropertyChangeListener;


public class TurtleManager {
	Turtle myTurtle;
	TurtleState myTurtleState;
	
	
	TurtleManager() {
		myTurtle = new Turtle();
		myTurtle.addPropertyChangeListener();
		
	}

}
