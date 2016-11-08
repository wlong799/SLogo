package view.turtle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;
import view.Commander;
import view.GUIElement;
import view.Style;
import view.Stylizable;

import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;

/**
 * Manages all of the turtles currently contained on screen, their associated line canvases, and which ones are active.
 * Can change appearance of turtles and lines, and can set which turtles are active through clicking.
 *
 * @author Will Long
 */
public class TurtleManager extends GUIElement implements Stylizable, Commander {
    private static final double CLICK_RANGE = 15;

    private Map<Integer, TurtleView> myTurtles;
    private Map<Integer, TurtleLines> myTurtleLines;
    private Set<Integer> myActiveTurtleNums;
    private Set<Integer> nextActiveTurtleNums;

    private StackPane myContainer;

    /**
     * Creates new empty turtle manager.
     *
     * @param width  is width of area to draw lines/turtles.
     * @param height is height of area to draw lines/turtles.
     */
    public TurtleManager(double width, double height) {
        super(width, height);
        myContainer = new StackPane();
        myTurtles = new HashMap<>();
        myTurtleLines = new HashMap<>();
        myActiveTurtleNums = new HashSet<>();
        myContainer.setClip(new Rectangle(width, height));
    }

    /**
     * Sets the currently active turtles to those with IDs specified. Creates new turtles in case new IDs are
     * encountered.
     *
     * @param nums is list of IDs of active turtles.
     */
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

    /**
     * Gets turtle view based on its ID.
     *
     * @param id is ID of turtle.
     * @return TurtleView of associated turtle.
     */
    public TurtleView getTurtle(int id) {
        return myTurtles.get(id);
    }

    /**
     * Gets turtle canvas based on its ID.
     *
     * @param id is ID of turtle.
     * @return TurtleLines of associated turtle.
     */
    public TurtleLines getTurtleLines(int id) {
        return myTurtleLines.get(id);
    }


    @Override
    public Node getContent() {
        return myContainer;
    }

    /**
     * Set the line color or turtle image of all active turtles.
     *
     * @param style is Style object with appearance information.
     */
    @Override
    public void setStyle(Style style) {
        for (TurtleLines turtleLines : getActiveTurtleLines()) {
            turtleLines.setStyle(style);
        }
        for (TurtleView turtleView : getActiveTurtles()) {
            turtleView.setStyle(style);
        }
    }

    /**
     * Returns turtle views of all active turtles.
     *
     * @return list of TurtleViews of active turtles.
     */
    private List<TurtleView> getActiveTurtles() {
        return myActiveTurtleNums.stream().filter(num -> num >= 0 && num < myTurtles.size()).map(
                num -> myTurtles.get(num)).collect(Collectors.toList());
    }

    /**
     * Returns turtle canvases of all active turtles.
     *
     * @return list of TurtleLines of active turtles.
     */
    private List<TurtleLines> getActiveTurtleLines() {
        return myActiveTurtleNums.stream().filter(num -> num >= 0 && num < myTurtleLines.size()).map(
                num -> myTurtleLines.get(num)).collect(Collectors.toList());
    }

    /**
     * Clears all canvases of their lines.
     */
    public void clearScreen() {
        myTurtleLines.values().forEach(TurtleLines::clearLines);
    }

    /**
     * Toggles whether or not a turtle is active on click.
     *
     * @param eventHandler is how the event should be handled upon trigger.
     */
    @Override
    public void setCommandTrigger(EventHandler<ActionEvent> eventHandler) {
        myContainer.setOnMouseClicked(event -> {
            nextActiveTurtleNums = new HashSet<>(myActiveTurtleNums);
            double xClick = event.getX() - myWidth / 2;
            double yClick = event.getY() - myHeight / 2;
            for (int id : myTurtles.keySet()) {
                TurtleView turtle = myTurtles.get(id);
                if (Math.abs(turtle.getX() - xClick) < CLICK_RANGE &&
                        Math.abs(turtle.getY() - yClick) < CLICK_RANGE) {
                    if (myActiveTurtleNums.contains(id)) {
                        nextActiveTurtleNums.remove(id);
                    } else {
                        nextActiveTurtleNums.add(id);
                    }
                }
            }
            eventHandler.handle(new ActionEvent());
        });
    }

    /**
     * Sends info to back-end on state of currently active turtles.
     *
     * @param language is the language to send the command in.
     * @return String telling back-end which turtles are active.
     */
    @Override
    public String getCommandText(String language) {
        ResourceBundle languageResource = ResourceBundle.getBundle("resources/languages/" + language);
        String tellCommand = languageResource.getString("Tell");
        if (tellCommand.contains("|")) {
            tellCommand = tellCommand.split("\\|")[0];
        }
        String activeTurtles = "";
        for (int id : nextActiveTurtleNums) {
            activeTurtles += " " + id;
        }
        return tellCommand + " [" + activeTurtles + " ]";
    }

    @Override
    public boolean storeHistory() {
        return false;
    }
}
