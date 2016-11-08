package view.panel;

import javafx.scene.Node;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import view.GUIElement;

/**
 * TabbedHelperPanel is the main GUI element on the side of the screen, and contains TabElements which display various
 * information about the current state of the back-end.
 *
 * @author Will Long
 */
public class TabbedHelperPanel extends GUIElement {

    private TabPane myTabContainer;

    /**
     * Creates an empty container of specified size, ready to add new tabs. Tabs cannot be closed.
     *
     * @param width  is width of container.
     * @param height is height of container.
     */
    public TabbedHelperPanel(double width, double height) {
        super(width, height);
        myTabContainer = new TabPane();
        myTabContainer.setPrefWidth(myWidth);
        myTabContainer.setPrefHeight(myHeight);
        myTabContainer.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);
    }

    /**
     * Places a TabElement into the container.
     *
     * @param newTabElement
     */
    public void placeElementInNewTab(TabElement newTabElement) {
        String tabName = newTabElement.getTabName();
        Node tabContent = newTabElement.getContent();
        Tab newTab = new Tab(tabName, tabContent);
        myTabContainer.getTabs().add(newTab);
    }

    public double getTabWidth() {
        return myWidth;
    }

    public double getTabHeight() {
        return myHeight;
    }

    @Override
    public Node getContent() {
        return myTabContainer;
    }
}
