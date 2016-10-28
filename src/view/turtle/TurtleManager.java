package view.turtle;

import javafx.scene.Node;
import javafx.scene.layout.StackPane;
import view.GUIElement;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TurtleManager extends GUIElement {
    private List<TurtleView> myTurtles;
    private List<TurtleLines> myTurtleLines;
    private Set<Integer> myActiveTurtleNums;

    private StackPane myContainer;

    public TurtleManager(double width, double height) {
        super(width, height);
        myContainer = new StackPane();
        myTurtles = new ArrayList<>();
        myTurtleLines = new ArrayList<>();
        myActiveTurtleNums = new HashSet<>();
    }

    public void addTurtle() {
        TurtleView turtle = new TurtleView();
        TurtleLines turtleLines = new TurtleLines(myWidth, myHeight);
        myTurtles.add(turtle);
        myTurtleLines.add(turtleLines);
        myContainer.getChildren().addAll(turtle.getContent(), turtleLines.getContent());
    }

    public void setActiveTurtleNums(List<Integer> nums) {
        myActiveTurtleNums.clear();
        myActiveTurtleNums.addAll(nums);
    }

    public List<TurtleView> getActiveTurtles() {
        List<TurtleView> activeTurtles = new ArrayList<>();
        for (int num : myActiveTurtleNums) {
            if (num >= 0 && num < myTurtles.size()) {
                activeTurtles.add(myTurtles.get(num));
            }
        }
        return activeTurtles;
    }

    public List<TurtleLines> getActiveTurtleLines() {
        List<TurtleLines> activeLines = new ArrayList<>();
        for (int num : myActiveTurtleNums) {
            if (num >= 0 && num < myTurtleLines.size()) {
                activeLines.add(myTurtleLines.get(num));
            }
        }
        return activeLines;
    }

    @Override
    public Node getContent() {
        return myContainer;
    }
}
