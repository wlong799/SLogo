package view.element;

import javafx.scene.Node;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;

import javax.swing.text.View;
import java.util.ArrayList;
import java.util.List;

/**
 * Sets up
 */
public class ContentGrid implements ViewElement{
    private static final double TOOLBAR_RATIO = 0.1;
    private static final double MAIN_PANEL_RATIO = 0.7;
    private static final double BOTTOM_BAR_RATIO = 0.2;
    private static final double HORIZONTAL_RATIO = 0.70;
    private static final double PADDING_RATIO = 0.05;

    private GridPane myContentGrid;
    private double myWidth, myHeight;
    private double myXPadding, myYPadding;
    private List<Double> myRowSizes, myColSizes;

    public ContentGrid(double width, double height) {
        myContentGrid = new GridPane();
        myWidth = width;
        myHeight = height;
        myXPadding = myWidth * PADDING_RATIO;
        myYPadding = myHeight * PADDING_RATIO;
        myContentGrid.setGridLinesVisible(true);

        setPadding();
        setGridSizing();
    }

    private void setPadding() {
        myContentGrid.setHgap(myXPadding);
        myContentGrid.setVgap(myYPadding);
    }

    private void setGridSizing() {
        ColumnConstraints column1 = new ColumnConstraints();
        ColumnConstraints column2 = new ColumnConstraints();
        double xSpaceRemaining = myWidth - myXPadding;
        column1.setPrefWidth(xSpaceRemaining * HORIZONTAL_RATIO);
        column2.setPercentWidth(xSpaceRemaining * (1 - HORIZONTAL_RATIO));
        myContentGrid.getColumnConstraints().addAll(column1, column2);

        RowConstraints row1 = new RowConstraints();
        RowConstraints row2 = new RowConstraints();
        RowConstraints row3 = new RowConstraints();
        double ySpaceRemaining = myHeight - 2 * myYPadding;
        row1.setPrefHeight(ySpaceRemaining * TOOLBAR_RATIO);
        row2.setPrefHeight(ySpaceRemaining * MAIN_PANEL_RATIO);
        row3.setPrefHeight(ySpaceRemaining * BOTTOM_BAR_RATIO);
        myContentGrid.getRowConstraints().addAll(row1, row2, row3);
    }

    public void addToolBarElement(ViewElement element) {
        myContentGrid.add(element.getContent(), 0, 0, 2, 1);
    }

    public void addMainElement(ViewElement element) {
        myContentGrid.add(element.getContent(), 0, 1, 1, 1);
    }

    public void addSidePanelElement(ViewElement element) {
        myContentGrid.add(element.getContent(), 1, 1, 1, 2);
    }

    public void addBottomBarElement(ViewElement element) {
        myContentGrid.add(element.getContent(), 0, 2, 1, 1);
    }

    @Override
    public Node getContent() {
        return myContentGrid;
    }

    public double getMainElementWidth() {
        return myContentGrid.getColumnConstraints().get(0).getPrefWidth();
    }

    public double getMainElementHeight() {
        return myContentGrid.getRowConstraints().get(1).getPrefHeight();
    }
}
