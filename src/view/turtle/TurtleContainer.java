package view.turtle;

import dataStorage.TurtleState;
import javafx.scene.Node;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import view.GUIElement;
import view.Style;
import view.Stylizable;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;


/**
 * Contains the overall view for the turtles. Includes the background and the manager for all the turtles and lines.
 * Initializes and runs the thread containing the animator as well.
 *
 * @author Will Long
 * @author James Marlotte
 */
public class TurtleContainer extends GUIElement implements Observer, Stylizable {
    private static final Color DEFAULT_BG_COLOR = Color.WHITE;

    private StackPane myContainer;
    private Rectangle myBackground;
    private TurtleManager myTurtleManager;
    private TurtleAnimator myTurtleAnimator;

    /**
     * Initializes a container of the specified size, with no turtles to start off. Creates and starts the animation
     * thread, as well as the empty TurtleManager.
     *
     * @param width  is width of container.
     * @param height is height of container.
     */
    public TurtleContainer(double width, double height) {
        super(width, height);
        myContainer = new StackPane();
        myBackground = new Rectangle(myWidth, myHeight, DEFAULT_BG_COLOR);
        myTurtleManager = new TurtleManager(myWidth, myHeight);
        myTurtleAnimator = new TurtleAnimator(myTurtleManager);
        Thread thread = new Thread(myTurtleAnimator);
        thread.setDaemon(true);
        thread.start();
        myContainer.getChildren().addAll(myBackground, myTurtleManager.getContent());
    }

    /**
     * Updates based on information received by observables in the back-end. Has to check for multiple things, including
     * appearance changes, screen clears, and new TurtleState change events.
     */
    @Override
    public void update(Observable o, Object arg) {
        if (arg instanceof String[]) {
            String[] array = (String[]) arg;
            Color bgColor = Color.web(array[0]);
            Color lineColor = Color.web(array[1]);
            double lineSize = Double.parseDouble(array[2]);

            setStyle(new Style(bgColor));
            myTurtleManager.setStyle(new Style(lineColor));
            myTurtleManager.setStyle(new Style(lineSize));
            return;
        }

        if (!(arg instanceof List)) {
            if (arg instanceof Boolean) {
                myTurtleManager.clearScreen();
            }
            return;
        }
        List<TurtleState> copiedList = new ArrayList<>();
        for (Object obj : (List) arg) {
            if (!(obj instanceof TurtleState)) {
                return;
            }
            copiedList.add((TurtleState) obj);
        }
        myTurtleAnimator.addEvent(copiedList);
    }

    /**
     * Changes the background color to color specified by style.
     *
     * @param style is Style object with appearance information.
     */
    @Override
    public void setStyle(Style style) {
        Color color = style.getColor();
        if (color != null) {
            myBackground.setFill(color);
        }
    }

    @Override
    public Node getContent() {
        return myContainer;
    }

    public TurtleManager getTurtleManager() {
        return myTurtleManager;
    }

    public TurtleAnimator getAnimator() {
        return myTurtleAnimator;
    }
}
