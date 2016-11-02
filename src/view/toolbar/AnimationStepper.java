package view.toolbar;

import javafx.scene.control.MenuItem;
import view.AnimationController;
import view.turtle.TurtleAnimator;

public class AnimationStepper extends MenuElement implements AnimationController {
    private static final String NAME = "Step Animation";

    private MenuItem myMenuItem;

    public AnimationStepper() {
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
