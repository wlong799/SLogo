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
    ColorPicker myBackgroundColorPicker;
    ColorPicker myLineColorPicker;

    public SettingsToolBar(double width, double height) {
        myWidth = width;
        myHeight = height;

        myToolBar = new ToolBar();
        myToolBar.setStyle("-fx-background-color: #00FF00");
        myToolBar.setPrefWidth(myWidth);
        myToolBar.setPrefHeight(myHeight);
        
        myLineColorPicker = new ColorPicker(Color.BLACK);
        myToolBar.getItems().add(myLineColorPicker);
        
        myBackgroundColorPicker = new ColorPicker();
        myToolBar.getItems().add(myBackgroundColorPicker);
        
    }
    
    public void setLineColorPickerHandler(EventHandler<ActionEvent> handler) {
        myLineColorPicker.setOnAction(handler);
    }

    public Color getSelectedLineColor() {
        return myLineColorPicker.getValue();
    }
    
    public void setBackgroundColorPickerHandler(EventHandler<ActionEvent> handler) {
        myBackgroundColorPicker.setOnAction(handler);
    }

    public Color getSelectedBackgroundColor() {
        return myBackgroundColorPicker.getValue();
    }

    @Override
    public Node getContent() {
        return myToolBar;
    }
}
