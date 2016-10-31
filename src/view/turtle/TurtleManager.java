package view.turtle;

import javafx.scene.Node;
import javafx.scene.layout.StackPane;
import view.GUIElement;
import view.Style;
import view.Stylizable;

import java.util.*;
import java.util.function.Consumer;

public class TurtleManager extends GUIElement implements Stylizable {
    private Map<Integer, TurtleView> myTurtles;
    private Map<Integer, TurtleLines> myTurtleLines;
    private Set<Integer> myActiveTurtleNums;

    private StackPane myContainer;

    public TurtleManager(double width, double height) {
        super(width, height);
        myContainer = new StackPane();
        myTurtles = new HashMap<>();
        myTurtleLines = new HashMap<>();
        myActiveTurtleNums = new HashSet<>();
    }

    public void setActiveTurtleNums(List<Integer> nums) {
        nums.stream().filter(num -> !myTurtles.containsKey(num)).forEach(num -> {
            TurtleView turtleView = new TurtleView();
            TurtleLines turtleLines = new TurtleLines(myWidth, myHeight);
            myContainer.getChildren().addAll(turtleView.getContent(), turtleLines.getContent());
            myTurtles.put(num, turtleView);
            myTurtleLines.put(num, turtleLines);
        });
        myActiveTurtleNums.stream().map(i -> myTurtles.get(i)).forEach(turtleView -> turtleView.setActiveStatus(false));
        myActiveTurtleNums.clear();
        myActiveTurtleNums.addAll(nums);
        myActiveTurtleNums.stream().map(i -> myTurtles.get(i)).forEach(turtleView -> turtleView.setActiveStatus(true));
    }

    public TurtleView getTurtle(int id) {
        return myTurtles.get(id);
    }

    public TurtleLines getTurtleLines(int id) {
        return myTurtleLines.get(id);
    }


    @Override
    public Node getContent() {
        return myContainer;
    }

    @Override
    public void setStyle(Style style) {
        for (TurtleLines turtleLines : getActiveTurtleLines()) {
            turtleLines.setStyle(style);
        }
        for (TurtleView turtleView : getActiveTurtles()) {
            turtleView.setStyle(style);
        }
    }

    private List<TurtleView> getActiveTurtles() {
        List<TurtleView> activeTurtles = new ArrayList<>();
        for (int num : myActiveTurtleNums) {
            if (num >= 0 && num < myTurtles.size()) {
                activeTurtles.add(myTurtles.get(num));
            }
        }
        return activeTurtles;
    }

    private List<TurtleLines> getActiveTurtleLines() {
        List<TurtleLines> activeLines = new ArrayList<>();
        for (int num : myActiveTurtleNums) {
            if (num >= 0 && num < myTurtleLines.size()) {
                activeLines.add(myTurtleLines.get(num));
            }
        }
        return activeLines;
    }
}
