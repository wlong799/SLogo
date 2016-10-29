package model.command.zeroParameter.turtle;

import model.command.AbstractCommand;
import java.util.List;


public class Home extends AbstractTeleportHomeTurtle {

    public Home (List<AbstractCommand> parameters) {
        super(parameters);
    }

    @Override
    protected double turtleExecute () {
        return goHome();
    }

}
