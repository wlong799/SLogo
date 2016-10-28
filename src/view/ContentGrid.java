package view;

import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.layout.*;
import view.panel.TabbedHelperPanel;
import view.textbox.TextEntryBox;
import view.toolbar.SettingsMenuBar;
import view.turtle.TurtleContainer;

/**
 * Sets up layout of workspace using a grid.
 */
public class ContentGrid extends GUIElement {
    private static final double MAIN_PANEL_WIDTH_RATIO = 0.70;
    private static final double MAIN_PANEL_HEIGHT_RATIO = 0.85;
    private static final double PADDING_RATIO = 0.02;
    private static final int ROW_1 = 1;
    private static final int ROW_2 = 2;
    private static final int COL_1 = 1;
    private static final int COL_2 = 2;

    private Pane myContent;
    private GridPane myGrid;
    private SettingsMenuBar mySettingsMenuBar;
    private TurtleContainer myTurtleContainer;
    private TextEntryBox myTextEntryBox;
    private TabbedHelperPanel myHelperPanel;

    private double myXPadding, myYPadding;
    private double myBorderSize;

    public ContentGrid(double width, double height, double borderSize) {
        super(width, height);

        myXPadding = myWidth * PADDING_RATIO;
        myYPadding = myHeight * PADDING_RATIO;
        myBorderSize = borderSize;

        myContent = new StackPane();
        myGrid = new GridPane();
        myContent.getChildren().add(myGrid);

        setGridPadding();
        setGridRowSizes();
        setGridColSizes();
    }

    public void addMenu(SettingsMenuBar menu) {
        if (mySettingsMenuBar != null) {
            myContent.getChildren().remove(mySettingsMenuBar);
        }
        mySettingsMenuBar = menu;
        myContent.getChildren().add(menu.getContent());
        StackPane.setAlignment(mySettingsMenuBar.getContent(), Pos.TOP_CENTER);
    }

    public void addTurtleView(TurtleContainer turtleContainer) {
        if (myTurtleContainer != null) {
            myGrid.getChildren().remove(myTurtleContainer);
        }
        myTurtleContainer = turtleContainer;
        myGrid.add(myTurtleContainer.getContent(), COL_1, ROW_1, 1, 1);
    }

    public void addHelperPanel(TabbedHelperPanel helperPanel) {
        if (myHelperPanel != null) {
            myGrid.getChildren().remove(myHelperPanel);
        }
        myHelperPanel = helperPanel;
        myGrid.add(myHelperPanel.getContent(), COL_2, ROW_1, 1, 2);
    }

    public void addTextBox(TextEntryBox textBox) {
        if (myTextEntryBox != null) {
            myGrid.getChildren().remove(myTextEntryBox);
        }
        myTextEntryBox = textBox;
        myGrid.add(myTextEntryBox.getContent(), COL_1, ROW_2, 1, 1);
    }

    @Override
    public Node getContent() {
        return myContent;
    }

    public double getTurtleViewWidth() {
        return myGrid.getColumnConstraints().get(COL_1).getPrefWidth();
    }

    public double getTurtleViewHeight() {
        return myGrid.getRowConstraints().get(ROW_1).getPrefHeight();
    }

    public double getHelperPanelWidth() {
        return myGrid.getColumnConstraints().get(COL_2).getPrefWidth();
    }

    public double getHelperPanelHeight() {
        return myGrid.getRowConstraints().get(ROW_1).getPrefHeight() +
                myGrid.getRowConstraints().get(ROW_2).getPrefHeight();
    }

    public double getTextBoxWidth() {
        return myGrid.getColumnConstraints().get(COL_1).getPrefWidth();
    }

    public double getTextBoxHeight() {
        return myGrid.getRowConstraints().get(ROW_2).getPrefHeight();
    }

    private void setGridPadding() {
        myGrid.setHgap(myXPadding);
        myGrid.setVgap(myYPadding);
    }

    private void setGridRowSizes() {
        RowConstraints topBorder = new RowConstraints(myBorderSize);
        RowConstraints bottomBorder = new RowConstraints(myBorderSize);
        double ySpaceRemaining = myHeight - (2 * myBorderSize) - (3 * myYPadding);
        RowConstraints mainRow = new RowConstraints(ySpaceRemaining * MAIN_PANEL_HEIGHT_RATIO);
        RowConstraints bottomRow = new RowConstraints(ySpaceRemaining * (1 - MAIN_PANEL_HEIGHT_RATIO));
        myGrid.getRowConstraints().addAll(topBorder, mainRow, bottomRow, bottomBorder);
    }

    private void setGridColSizes() {
        ColumnConstraints leftBorder = new ColumnConstraints(myBorderSize);
        ColumnConstraints rightBorder = new ColumnConstraints(myBorderSize);
        double xSpaceRemaining = myWidth - (2 * myBorderSize) - (3 * myXPadding);
        ColumnConstraints mainCol = new ColumnConstraints(xSpaceRemaining * MAIN_PANEL_WIDTH_RATIO);
        ColumnConstraints sideCol = new ColumnConstraints(xSpaceRemaining * (1 - MAIN_PANEL_WIDTH_RATIO));
        myGrid.getColumnConstraints().addAll(leftBorder, mainCol, sideCol, rightBorder);
    }


}
