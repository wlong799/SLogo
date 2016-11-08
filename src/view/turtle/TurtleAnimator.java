package view.turtle;

import dataStorage.TurtleState;
import javafx.animation.*;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.event.EventHandler;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.util.Duration;
import view.Style;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Animates the turtle view. Implements runnable so that the back-end doesn't stall while animation is running. Takes in
 * lists of turtle states, representing single events to be animated, and runs all animations for single events in
 * parallel. Adds events to growing queue in case the view is already animating.
 *
 * @author Will Long
 */
public class TurtleAnimator implements Runnable {
    private static final double DEFAULT_DURATION = 1500;
    private static final long SLEEP_TIME = 250;

    private TurtleManager myTurtleManager;
    private double myDurationMilliseconds;
    private Queue<List<TurtleState>> myEventQueue;
    private TurtleView myCurrentTurtleView;
    private TurtleLines myCurrentTurtleLines;
    private double xOffset, yOffset;
    private List<Animation> upcomingAnimations;
    private boolean isCurrentlyAnimating, isRunning;
    private double myRate;

    /**
     * Sets up the animator to prepare to animate the turtles within the specified manager.
     *
     * @param manager is the TurtleManager class to use.
     */
    public TurtleAnimator(TurtleManager manager) {
        myDurationMilliseconds = DEFAULT_DURATION;
        myTurtleManager = manager;
        myEventQueue = new LinkedList<>();
        xOffset = myTurtleManager.getWidth() / 2;
        yOffset = myTurtleManager.getHeight() / 2;
        isCurrentlyAnimating = false;
        isRunning = true;
        myRate = 1;
    }

    /**
     * Add a new event to be animated to the event queue
     *
     * @param turtleStateList is a list of TurtleStates corresponding to a single event.
     */
    public void addEvent(List<TurtleState> turtleStateList) {
        myEventQueue.add(turtleStateList);
    }

    /**
     * Repeatedly check for any new events to animate, and run them if available and no other animations running.
     */
    @Override
    public void run() {
        while (true) {
            if (myEventQueue.isEmpty() || isCurrentlyAnimating || !isRunning) {
                try {
                    Thread.sleep(SLEEP_TIME);
                } catch (InterruptedException e) {
                    System.out.println("Animation thread interrupted");
                }
                continue;
            }
            runAnimation(myEventQueue.poll());
        }
    }

    /**
     * Set whether or not animations should run.
     *
     * @param running is true if animator should run, false if it should pause.
     */
    public void setRunning(boolean running) {
        isRunning = running;
    }

    /**
     * Sets the current animation speed.
     *
     * @param rate is rate to adjust default speed by.
     */
    public void setRate(double rate) {
        myRate = rate;
    }

    /**
     * If the animation is currently paused, step forward by one animation.
     */
    public void step() {
        if (myEventQueue.isEmpty() || isCurrentlyAnimating || isRunning) {
            return;
        }
        runAnimation(myEventQueue.poll());
    }

    /**
     * Run all animations for the transitions to the new turtle states in parallel.
     *
     * @param turtleStates are the TurtleStates to transition to.
     */
    private void runAnimation(List<TurtleState> turtleStates) {
        myDurationMilliseconds = DEFAULT_DURATION / myRate;
        isCurrentlyAnimating = true;
        upcomingAnimations = new ArrayList<>();
        turtleStates.forEach(this::addAnimations);
        ParallelTransition mainAnimation = new ParallelTransition();
        mainAnimation.getChildren().addAll(upcomingAnimations);
        mainAnimation.setOnFinished(event -> {
            isCurrentlyAnimating = false;
        });
        mainAnimation.play();
    }

    private void addAnimations(TurtleState turtleState) {
        myCurrentTurtleView = myTurtleManager.getTurtle(turtleState.getID());
        myCurrentTurtleLines = myTurtleManager.getTurtleLines(turtleState.getID());
        myCurrentTurtleLines.setStyle(new Style(turtleState.getPenDownStatus()));

        double x = turtleState.getPosition().getX();
        double y = turtleState.getPosition().getY();

        addAnimatePosition(x, y);
        addAnimateVisibility(turtleState.getVisibility());
        addAnimateHeading(turtleState.getHeading());
        addAnimateLine(x, y);
    }

    private void addAnimatePosition(double xEnd, double yEnd) {
        double xStart = myCurrentTurtleView.getX() + xOffset;
        double yStart = myCurrentTurtleView.getY() + yOffset;
        xEnd += xOffset;
        yEnd += yOffset;
        if (Math.abs(xStart - xEnd) < 1 && Math.abs(yStart - yEnd) < 1) {
            return;
        }
        MoveTo moveTo = new MoveTo(xStart, yStart);
        LineTo lineTo = new LineTo(xEnd, yEnd);
        Path path = new Path(moveTo, lineTo);
        upcomingAnimations.add(new PathTransition(Duration.millis(myDurationMilliseconds), path,
                myCurrentTurtleView.getContent()));
    }

    private void addAnimateVisibility(boolean visible) {
        if ((visible && myCurrentTurtleView.isVisible()) || (!visible && !myCurrentTurtleView.isVisible())) {
            return;
        }
        FadeTransition fadeTransition = new FadeTransition(Duration.millis(myDurationMilliseconds),
                myCurrentTurtleView.getContent());
        fadeTransition.setFromValue(myCurrentTurtleView.getCorrectOpacity(myCurrentTurtleView.isVisible()));
        fadeTransition.setToValue(myCurrentTurtleView.getCorrectOpacity(visible));
        upcomingAnimations.add(fadeTransition);
    }

    private void addAnimateHeading(double heading) {
        heading += 90;
        if (heading == myCurrentTurtleView.getHeading()) {
            return;
        }
        RotateTransition rotateTransition = new RotateTransition(Duration.millis(myDurationMilliseconds),
                myCurrentTurtleView.getContent());
        rotateTransition.setFromAngle(myCurrentTurtleView.getHeading());
        rotateTransition.setToAngle(heading);
        upcomingAnimations.add(rotateTransition);
    }

    private void addAnimateLine(double xEnd, double yEnd) {
        double xStart = myCurrentTurtleView.getX() + xOffset;
        double yStart = myCurrentTurtleView.getY() + yOffset;
        xEnd += xOffset;
        yEnd += yOffset;
        if (Math.abs(xStart - xEnd) < 1 && Math.abs(yStart - yEnd) < 1) {
            return;
        }
        DoubleProperty x = new SimpleDoubleProperty();
        DoubleProperty y = new SimpleDoubleProperty();

        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                if (myCurrentTurtleLines.getIsPenDown()) {
                    myCurrentTurtleLines.drawLine(xStart, yStart, x.get(), y.get());
                }
            }
        };

        EventHandler onFinished = event -> timer.stop();
        KeyFrame startFrame = new KeyFrame(Duration.millis(0),
                new KeyValue(x, xStart),
                new KeyValue(y, yStart));
        KeyFrame endFrame = new KeyFrame(Duration.millis(myDurationMilliseconds),
                onFinished,
                new KeyValue(x, xEnd),
                new KeyValue(y, yEnd));

        Timeline timeline = new Timeline(startFrame, endFrame);

        timeline.play();
        timer.start();
    }

}
