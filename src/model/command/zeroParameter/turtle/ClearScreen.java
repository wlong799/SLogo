package model.command.zeroParameter.turtle;

import dataStorage.DataStorageManager;
import dataStorage.Position;
import model.command.AbstractCommand;
import model.command.twoParameter.turtle.SetPosition;
import java.util.List;


public class ClearScreen extends AbstractTeleportHomeTurtle {

    public ClearScreen(List<AbstractCommand> parameters) {
        super(parameters);
    }

    public double execute() {
        double distance = goHome();
        DataStorageManager.get().getNotifications().setClearScreenFlag();
        return distance;
    }

}
