package view;

import javafx.scene.Parent;
import view.element.*;

import java.util.ArrayList;
import java.util.List;

/**
 * WorkspaceContent just provides a quick setup for the application. Non-resizable, and provides a
 * TurtleView, with a TextEntryBox beneath.
 */
public class WorkspaceContent implements ContentManager {
    private static final double BORDER_RATIO = 0.05;

    private ContentGrid myContentGrid;
    private List<Viewable> myViewables;

    private double myWidth;
    private double myHeight;

    private TabbedHelperPanel myHelperPanel;

    public WorkspaceContent(double width, double height) {
        myWidth = width;
        myHeight = height;
        double borderSize = Math.min(myHeight, myWidth) * BORDER_RATIO;
        myContentGrid = new ContentGrid(width, height, borderSize);
        myViewables = new ArrayList<>();
        createMainElement();
        createToolBarElement();
        createHelperPanelElement();
        createBottomBarElement();
    }

    @Override
    public Parent getContentLayout() {
        return (Parent) myContentGrid.getContent();
    }

    @Override
    public List<Viewable> getElements() {
        return myViewables;
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
        myViewables.add(settingsToolBar);
    }

    private void createMainElement() {
        double width = myContentGrid.getMainElementWidth();
        double height = myContentGrid.getMainElementHeight();
        TurtleView turtleView = new TurtleView(width, height);
        myContentGrid.addMainElement(turtleView);
        myViewables.add(turtleView);
    }

    private void createHelperPanelElement() {
        double width = myContentGrid.getSidePanelWidth();
        double height = myContentGrid.getSidePanelHeight();
        myHelperPanel = new TabbedHelperPanel(width, height);
        myViewables.add(myHelperPanel);
        myContentGrid.addSidePanelElement(myHelperPanel);
    }

    private void createBottomBarElement() {
        double width = myContentGrid.getBottomBarWidth();
        double height = myContentGrid.getBottomBarHeight();
        TextEntryBox textEntryBox = new TextEntryBox(width, height);
        myContentGrid.addBottomBarElement(textEntryBox);
        myViewables.add(textEntryBox);
    }

    public void addTab(String tabClass) {
        double tabWidth = myHelperPanel.getTabWidth();
        double tabHeight = myHelperPanel.getTabHeight();
        TabElement tab;
        try {
            Object obj = Class.forName(tabClass).getConstructor(double.class, double.class).newInstance(tabWidth, tabHeight);
            if (obj instanceof TabElement) {
                tab = (TabElement) obj;
            } else {
                throw new ClassCastException();
            }
        } catch (ClassNotFoundException e) {
            System.err.println("Tab class not found: " + tabClass);
            return;
        } catch (NoSuchMethodException e) {
            System.err.println("Constructor not found for class: " + tabClass);
            return;
        } catch (ClassCastException e) {
            System.err.println("Class does not extend TabElement: " + tabClass);
            return;
        } catch (Exception e) {
            System.err.println("Error when instantiating object: " + tabClass);
            return;
        }
        myHelperPanel.placeElementInNewTab(tab);
        myViewables.add(tab);
    }
}
