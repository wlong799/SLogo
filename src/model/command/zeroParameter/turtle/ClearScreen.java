package model.command.zeroParameter.turtle;

import model.command.AbstractCommand;
import java.util.List;


public class ClearScreen extends AbstractTeleportHomeTurtle {

    public ClearScreen (List<AbstractCommand> parameters) {
        super(parameters);
    }

    protected double turtleExecute () {
        double distance = goHome();
        // getData.getNotifications().setClearScreenFlag();

        // somehow tell front end to clear the screen
        return distance;
    }

}
