package view;

import view.turtle.TurtleAnimator;

/**
 * Classes that implement this interface are able to interact with the main animator for SLogo, and set various
 * parameters such as run speed, start/stop, etc.
 *
 * @author Will Long
 */
public interface AnimationController {
    /**
     * Set up interaction with the animator.
     * @param animator is the TurtleAnimator to interact with.
     */
    void setAnimationControl(TurtleAnimator animator);
}
