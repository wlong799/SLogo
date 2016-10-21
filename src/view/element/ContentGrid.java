package view.element;

import javafx.scene.Node;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;

import javax.swing.text.View;

/**
 * Sets up
 */
public class ContentGrid implements ViewElement{
    private static final double TOOLBAR_RATIO = 0.1;
    private static final double MAIN_PANEL_RATIO = 0.7;
    private static final double BOTTOM_BAR_RATIO = 0.2;
    private static final double HORIZONTAL_RATIO = 0.75;
    private static final double PADDING_RATIO = 0.05;

    private GridPane myContentGrid;
    private double myWidth, myHeight;

    public ContentGrid(double width, double height) {
        myContentGrid = new GridPane();
        myWidth = width;
        myHeight = height;

        setPadding();
        setGridSizing();
    }

    private void setPadding() {
        myContentGrid.setHgap(myWidth * PADDING_RATIO);
        myContentGrid.setVgap(myHeight * PADDING_RATIO);
    }

    private void setGridSizing() {
        ColumnConstraints column1 = new ColumnConstraints();
        ColumnConstraints column2 = new ColumnConstraints();
        column1.setPercentWidth(HORIZONTAL_RATIO * 100);
        column2.setPercentWidth(100 * (1 - HORIZONTAL_RATIO));
        myContentGrid.getColumnConstraints().addAll(column1, column2);

        RowConstraints row1 = new RowConstraints();
        RowConstraints row2 = new RowConstraints();
        RowConstraints row3 = new RowConstraints();
        row1.setPercentHeight(100 * TOOLBAR_RATIO);
        row2.setPercentHeight(100 * MAIN_PANEL_RATIO);
        row3.setPercentHeight(100 * BOTTOM_BAR_RATIO);
        myContentGrid.getRowConstraints().addAll(row1, row2, row3);
    }

    public void addToolBarElement(ViewElement element) {
        myContentGrid.add(element.getContent(), 0, 0, 2, 1);
        myContentGrid.getChildren().add(element.getContent());
    }

    public void addMainPanelElement(ViewElement element) {
        myContentGrid.add(element.getContent(), 0, 1, 1, 1);
        myContentGrid.getChildren().add(element.getContent());
    }

    public void addSidePanelElement(ViewElement element) {
        myContentGrid.add(element.getContent(), 1, 1, 1, 2);
        myContentGrid.getChildren().add(element.getContent());
    }

    public void addBottomBarElement(ViewElement element) {
        myContentGrid.add(element.getContent(), 0, 2, 1, 1);
        myContentGrid.getChildren().add(element.getContent());
    }

    @Override
    public Node getContent() {
        return myContentGrid;
    }
}
