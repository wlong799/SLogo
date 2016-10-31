package model.command.zeroParameter.turtle;

import model.command.AbstractCommand;
import java.util.List;
import dataStorage.DataStorageManager;
import dataStorage.TurtleStorage;


public class ClearScreen extends AbstractTeleportHomeTurtle {

    private DataStorageManager myData;

    public ClearScreen (List<AbstractCommand> parameters) {
        super(parameters);
    }

    @Override
    public void addOtherParameters (DataStorageManager data, TurtleStorage turtles) {
        myData = data;
    }

    protected double turtleExecute () {
        double distance = goHome();
        myData.getNotifications().setClearScreenFlag();

        // somehow tell front end to clear the screen
        return distance;
    }

}
