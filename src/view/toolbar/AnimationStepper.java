package view.toolbar;

import javafx.scene.control.MenuItem;
import view.AnimationController;
import view.turtle.TurtleAnimator;

/**
 * Menu element that steps through animation of turtle window one-by-one when clicked.
 *
 * @author Will Long
 */
public class AnimationStepper extends MenuElement implements AnimationController {
    private static final String NAME = "Step Animation";

    private MenuItem myMenuItem;

    public AnimationStepper() {
        myMenuItem = new MenuItem(NAME);
    }
    @Override
    public void setAnimationControl(TurtleAnimator animator) {
        myMenuItem.setOnAction(event -> animator.step());
    }

    @Override
    public MenuItem getMenuItem() {
        return myMenuItem;
    }
}
