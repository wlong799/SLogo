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

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TurtleAnimator implements Runnable {
    private static final double DEFAULT_DURATION = 1000;
    private static final long SLEEP_TIME = 250;

    private TurtleManager myTurtleManager;
    private double myDurationMilliseconds;
    private Queue<List<TurtleState>> myEventQueue;
    private TurtleView myCurrentTurtleView;
    private TurtleLines myCurrentTurtleLines;
    private double xOffset, yOffset;
    private List<Animation> upcomingAnimations;
    boolean isAnimating;

    public TurtleAnimator(TurtleManager manager) {
        myDurationMilliseconds = DEFAULT_DURATION;
        myTurtleManager = manager;
        myEventQueue = new LinkedList<>();
        xOffset = myTurtleManager.getWidth() / 2;
        yOffset = myTurtleManager.getHeight() / 2;
        isAnimating = false;
    }

    public void addEvent(List<TurtleState> turtleStateList) {
        myEventQueue.add(turtleStateList);
    }

    @Override
    public void run() {
        while (true) {
            if (myEventQueue.isEmpty() || isAnimating) {
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

    private void runAnimation(List<TurtleState> turtleStates) {
        isAnimating = true;
        upcomingAnimations = new ArrayList<>();
        turtleStates.forEach(this::addAnimations);
        ParallelTransition mainAnimation = new ParallelTransition();
        mainAnimation.getChildren().addAll(upcomingAnimations);
        mainAnimation.setOnFinished(event -> {
            isAnimating = false;
        });
        mainAnimation.play();
    }

    private void addAnimations(TurtleState turtleState) {
        myCurrentTurtleView = myTurtleManager.getTurtle(turtleState.getID());
        myCurrentTurtleLines = myTurtleManager.getTurtleLines(turtleState.getID());

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
            	if(myCurrentTurtleLines.getIsPenDown()==true){
                myCurrentTurtleLines.drawLine(xStart, yStart, x.get(), y.get());
            }
        };};

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
