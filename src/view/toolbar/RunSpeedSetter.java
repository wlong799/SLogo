package view.toolbar;

import javafx.scene.control.MenuItem;
import javafx.scene.control.Slider;
import view.AnimationController;
import view.turtle.TurtleAnimator;

/**
 * Menu element with a slider that can set the run speed of the animation.
 *
 * @author Will Long
 */
public class RunSpeedSetter extends MenuElement implements AnimationController {
    private static final String NAME = "Set Run Speed";
    private static final double MIN_RATE = 0.1;
    private static final double DEFAULT_RATE = 1;
    private static final double MAX_RATE = 10;


    private MenuItem myMenuItem;
    private Slider myRunSpeedSlider;

    public RunSpeedSetter() {
        myRunSpeedSlider = new Slider(MIN_RATE, MAX_RATE, DEFAULT_RATE);
        myMenuItem = new MenuItem(NAME, myRunSpeedSlider);
    }

    @Override
    public void setAnimationControl(TurtleAnimator animator) {
        myRunSpeedSlider.valueProperty().addListener((observable, oldValue, newValue) -> {
            animator.setRate(newValue.doubleValue());
        });
    }

    @Override
    public MenuItem getMenuItem() {
        return myMenuItem;
    }
}
