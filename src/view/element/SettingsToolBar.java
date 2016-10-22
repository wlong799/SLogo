package view.element;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ToolBar;
import javafx.scene.paint.Color;

/**
 * @author Will Long
 * @version 10/19/16
 */
public class SettingsToolBar implements ViewElement{
    private double myWidth, myHeight;

    private ToolBar myToolBar;
    ColorPicker myColorPicker;

    public SettingsToolBar(double width, double height) {
        myWidth = width;
        myHeight = height;

        myToolBar = new ToolBar();
        myToolBar.setStyle("-fx-background-color: #00FF00");
        myToolBar.setPrefWidth(myWidth);
        myToolBar.setPrefHeight(myHeight);

        myColorPicker = new ColorPicker();
        myToolBar.getItems().add(myColorPicker);
    }

    public void setBackgroundColorPickerHandler(EventHandler<ActionEvent> handler) {
        myColorPicker.setOnAction(handler);
    }

    public Color getSelectedBackgroundColor() {
        return myColorPicker.getValue();
    }

    @Override
    public Node getContent() {
        return myToolBar;
    }
}
