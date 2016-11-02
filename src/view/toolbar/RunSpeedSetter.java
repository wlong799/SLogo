package view.toolbar;

import javafx.scene.control.MenuItem;
import view.AnimationController;
import view.turtle.TurtleAnimator;

public class RunSpeedSetter extends MenuElement implements AnimationController{
    private static final String NAME = "Set Run Speed";

    private MenuItem myMenuItem;

    public RunSpeedSetter() {
        myMenuItem = new MenuItem(NAME);
    }
    @Override
    public void setAnimationControl(TurtleAnimator animator) {

    }

    @Override
    public MenuItem getMenuItem() {
        return myMenuItem;
    }
}
