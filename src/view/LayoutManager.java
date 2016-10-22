package view;

import javafx.scene.Parent;
import view.element.*;

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
    private static final double BORDER_RATIO = 0.05;

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
        double borderSize = Math.min(myHeight, myWidth) * BORDER_RATIO;
        myContentGrid = new ContentGrid(width, height, borderSize);
        myViewElements = new ArrayList<>();
        createMainElement();
        createToolBarElement();
        createSidePanelElement();
        createBottomBarElement();
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

    private void createToolBarElement() {
        double width = myContentGrid.getToolbarWidth();
        double height = myContentGrid.getToolbarHeight();
        SettingsToolBar settingsToolBar = new SettingsToolBar(width, height);
        myContentGrid.addToolBarElement(settingsToolBar);
        myViewElements.add(settingsToolBar);
    }

    private void createMainElement() {
        double width = myContentGrid.getMainElementWidth();
        double height = myContentGrid.getMainElementHeight();
        TurtleView turtleView = new TurtleView(width, height);
        myContentGrid.addMainElement(turtleView);
        myViewElements.add(turtleView);
    }

    private void createSidePanelElement() {
        double width = myContentGrid.getSidePanelWidth();
        double height = myContentGrid.getSidePanelHeight();
        TabbedHelperPanel tabbedHelperPanel = new TabbedHelperPanel(width, height);
        double tabWidth = tabbedHelperPanel.getTabWidth();
        double tabHeight = tabbedHelperPanel.getTabHeight();
        CommandHistoryWindow commandHistoryWindow = new CommandHistoryWindow(tabWidth, tabHeight);
        StoredFunctionWindow storedFunctionWindow = new StoredFunctionWindow(tabWidth, tabHeight);
        tabbedHelperPanel.placeElementInNewTab("Command History", commandHistoryWindow);
        tabbedHelperPanel.placeElementInNewTab("Stored Functions", storedFunctionWindow);
        myContentGrid.addSidePanelElement(tabbedHelperPanel);
        myViewElements.add(tabbedHelperPanel);
        myViewElements.add(commandHistoryWindow);
        myViewElements.add(storedFunctionWindow);
    }

    private void createBottomBarElement() {
        double width = myContentGrid.getBottomBarWidth();
        double height = myContentGrid.getBottomBarHeight();
        TextEntryBox textEntryBox = new TextEntryBox(width, height);
        myContentGrid.addBottomBarElement(textEntryBox);
        myViewElements.add(textEntryBox);
    }
}
