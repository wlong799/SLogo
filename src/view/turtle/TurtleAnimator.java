package view.turtle;

import dataStorage.TurtleState;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TurtleAnimator implements Runnable {
    private static final double DEFAULT_DURATION = 1000;
    private static final long SLEEP_TIME = 1000;

    private TurtleManager myTurtleManager;
    private double myDurationMilliseconds;
    private Queue<List<TurtleState>> myEventQueue;

    public TurtleAnimator(TurtleManager manager) {
        myDurationMilliseconds = DEFAULT_DURATION;
        myTurtleManager = manager;
        myEventQueue = new LinkedList<>();
    }

    public void addEvent(List<TurtleState> turtleStateList) {
        myEventQueue.add(turtleStateList);
    }

    @Override
    public void run() {
        while (true) {
            if (myEventQueue.isEmpty()) {
                try {
                    Thread.sleep(SLEEP_TIME);
                } catch (InterruptedException e) {
                    System.out.println("Animation thread interrupted");
                }
                continue;
            }
            List<TurtleState> turtleStateList = myEventQueue.poll();
            turtleStateList.forEach(this::draw);
        }
    }

    private void draw (TurtleState turtleState) {
        TurtleView turtleView = myTurtleManager.getTurtle(turtleState.getID());
        TurtleLines turtleLines = myTurtleManager.getTurtleLines(turtleState.getID());

        double x1 = turtleView.getX();
        double y1 = turtleView.getY();
        double x2 = turtleState.getPosition().getX();
        double y2 = turtleState.getPosition().getY();

        turtleView.setPosition(x2, y2);
        turtleLines.drawLine(x1, y1, x2, y2);
        turtleView.setTurtleHeading(turtleState.getHeading());
        turtleView.setTurtleVisibility(turtleState.getVisibility());
    }
}
