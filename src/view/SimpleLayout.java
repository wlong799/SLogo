package view;

import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.TextArea;
import sun.java2d.pipe.SpanShapeRenderer;

import java.util.ArrayList;
import java.util.List;

/**
 * SimpleLayout just provides a quick setup for the application. Non-resizable, and provides a
 * TurtleView, with a TextEntryBox beneath.
 */
public class SimpleLayout implements LayoutManager {
    private static final double MIN_WIDTH = 500;
    private static final double DEFAULT_WIDTH = 1000;
    private static final double MAX_WIDTH = 1500;
    private static final double MIN_HEIGHT = 375;
    private static final double DEFAULT_HEIGHT = 750;
    private static final double MAX_HEIGHT = 1125;
    private static final double PADDING_RATIO = 0.05;
    private static final double TEXT_BOX_RATIO = 0.1;

    private Group root;
    private List<ViewElement> myViewElements;
    private double myWidth;
    private double myHeight;
    private double myPadding;

    public SimpleLayout() {
        this(DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }

    public SimpleLayout(double width, double height) {
        root = new Group();
        myWidth = Math.min(MAX_WIDTH, Math.max(MIN_WIDTH, width));
        myHeight = Math.min(MAX_HEIGHT, Math.max(MIN_HEIGHT, height));
        myPadding = Math.min(myWidth, myHeight) * PADDING_RATIO;

        double elementWidth = myWidth - 2 * myPadding;
        double textBoxHeight = TEXT_BOX_RATIO * myHeight;
        double turtleHeight = myHeight - 3 * myPadding - textBoxHeight;
        TurtleView turtleView = new TurtleView(myPadding, myPadding, elementWidth, turtleHeight);
        TextEntryBox textEntryBox = new TextEntryBox(myPadding, myHeight - myPadding - textBoxHeight,
                                                     elementWidth, textBoxHeight);

        myViewElements = new ArrayList<>();
        myViewElements.add(turtleView);
        myViewElements.add(textEntryBox);
    }

    @Override
    public Parent getElementLayout() {
        root = new Group();
        for (ViewElement element : myViewElements) {
            root.getChildren().add(element.getContent());
        }
        return root;
    }

    @Override
    public List<ViewElement> getViewElements() {
        return myViewElements;
    }

    @Override
    public double getWidth() {
        return myWidth;
    }

    @Override
    public double getHeight() {
        return myHeight;
    }
}
