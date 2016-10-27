package view.element;

import javafx.scene.Node;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;

/**
 * @author Will Long
 * @version 10/19/16
 */
public class TabbedHelperPanel implements Viewable {

    private TabPane myTabContainer;

    private double myWidth, myHeight;

    public TabbedHelperPanel(double width, double height) {
        myWidth = width;
        myHeight = height;

        myTabContainer = new TabPane();
        myTabContainer.setPrefWidth(myWidth);
        myTabContainer.setPrefHeight(myHeight);
        myTabContainer.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);
    }

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
