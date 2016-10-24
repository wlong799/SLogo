package model.command;

import dataStorage.DataStorageManager;
import dataStorage.Position;
import model.ExpressionNode;
import java.util.List;
import model.command.SetPosition;


public class ClearScreen extends AbstractTeleportHomeTurtle {

    public ClearScreen(List<ExpressionNode> parameters) {
        super(parameters);
    }

    public double execute() {
        double distance = goHome();
        DataStorageManager.get().getNotifications().setClearScreenFlag();
        return distance;
    }

}
