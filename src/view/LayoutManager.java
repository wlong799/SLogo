package view;

import javafx.scene.Parent;
import view.element.ContentGrid;
import view.element.TurtleView;
import view.element.ViewElement;

import java.util.ArrayList;
import java.util.List;

/**
 * LayoutManager just provides a quick setup for the application. Non-resizable, and provides a
 * TurtleView, with a TextEntryBox beneath.
 */
public class LayoutManager {
    private static final double MIN_WIDTH = 500;
    private static final double DEFAULT_WIDTH = 1000;
    private static final double MAX_WIDTH = 1500;
    private static final double MIN_HEIGHT = 375;
    private static final double DEFAULT_HEIGHT = 750;
    private static final double MAX_HEIGHT = 1125;

    private ContentGrid myContentGrid;
    private List<ViewElement> myViewElements;
    private double myWidth;
    private double myHeight;
    private double myPadding;

    public LayoutManager() {
        this(DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }

    public LayoutManager(double width, double height) {
        myWidth = Math.min(MAX_WIDTH, Math.max(MIN_WIDTH, width));
        myHeight = Math.min(MAX_HEIGHT, Math.max(MIN_HEIGHT, height));
        myContentGrid = new ContentGrid(width, height);
        myViewElements = new ArrayList<>();
        createMainElement();
        //createToolBarElement();
        //createSidePanelElement();
        //createBottomBarElement();
    }

    public Parent getElementLayout() {
       return (Parent) myContentGrid.getContent();
    }

    public List<ViewElement> getViewElements() {
        return myViewElements;
    }

    public double getWidth() {
        return myWidth;
    }

    public double getHeight() {
        return myHeight;
    }

    private void createMainElement() {
        double width = myContentGrid.getMainElementWidth();
        double height = myContentGrid.getMainElementHeight();
        TurtleView turtleView = new TurtleView(width, height);
        myContentGrid.addMainElement(turtleView);
        myViewElements.add(turtleView);
    }
}
