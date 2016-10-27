package view;

import javafx.scene.Node;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;

/**
 * Sets up
 */
public class ContentGrid implements Viewable {
    private static final double TOOLBAR_RATIO = 0.1;
    private static final double MAIN_PANEL_RATIO = 0.75;
    private static final double BOTTOM_BAR_RATIO = 0.15;
    private static final double HORIZONTAL_RATIO = 0.70;
    private static final double PADDING_RATIO = 0.02;

    private GridPane myContentGrid;
    private double myWidth, myHeight;
    private double myXPadding, myYPadding;

    public ContentGrid(double width, double height, double borderSize) {
        myWidth = width - 2 * borderSize;
        myHeight = height - 2 * borderSize;

        myContentGrid = new GridPane();
        myContentGrid.setLayoutX(borderSize);
        myContentGrid.setLayoutY(borderSize);
        myContentGrid.setStyle("-fx-background-color: white");
        myXPadding = myWidth * PADDING_RATIO;
        myYPadding = myHeight * PADDING_RATIO;

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
        column2.setPrefWidth(xSpaceRemaining * (1 - HORIZONTAL_RATIO));
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

    public void addToolBarElement(Viewable element) {
        myContentGrid.add(element.getContent(), 0, 0, 2, 1);
    }

    public void addMainElement(Viewable element) {
        myContentGrid.add(element.getContent(), 0, 1, 1, 1);
    }

    public void addSidePanelElement(Viewable element) {
        myContentGrid.add(element.getContent(), 1, 1, 1, 2);
    }

    public void addBottomBarElement(Viewable element) {
        myContentGrid.add(element.getContent(), 0, 2, 1, 1);
    }

    @Override
    public Node getContent() {
        return myContentGrid;
    }

    public double getToolbarWidth() {
        return myWidth;
    }

    public double getToolbarHeight() {
        return myContentGrid.getRowConstraints().get(0).getPrefHeight();
    }

    public double getMainElementWidth() {
        return myContentGrid.getColumnConstraints().get(0).getPrefWidth();
    }

    public double getMainElementHeight() {
        return myContentGrid.getRowConstraints().get(1).getPrefHeight();
    }

    public double getSidePanelWidth() {
        return myContentGrid.getColumnConstraints().get(1).getPrefWidth();
    }

    public double getSidePanelHeight() {
        return myContentGrid.getRowConstraints().get(1).getPrefHeight() +
                myContentGrid.getRowConstraints().get(2).getPrefHeight();
    }

    public double getBottomBarWidth() {
        return myContentGrid.getColumnConstraints().get(0).getPrefWidth();
    }

    public double getBottomBarHeight() {
        return myContentGrid.getRowConstraints().get(2).getPrefHeight();
    }
}
