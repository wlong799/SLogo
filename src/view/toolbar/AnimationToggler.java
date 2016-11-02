package view.toolbar;

import javafx.scene.control.CheckBox;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.MenuItem;
import view.AnimationController;
import view.turtle.TurtleAnimator;

public class AnimationToggler extends MenuElement implements AnimationController{
    private static final String NAME = "Set Running";

    private CheckMenuItem myMenuItem;

    public AnimationToggler() {
        myMenuItem = new CheckMenuItem(NAME);
        myMenuItem.setSelected(true);
    }
    @Override
    public void setAnimationControl(TurtleAnimator animator) {

    }

    @Override
    public MenuItem getMenuItem() {
        return myMenuItem;
    }
}
