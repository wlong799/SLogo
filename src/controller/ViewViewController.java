package controller;

import dataStorage.Turtle;
import view.element.SettingsToolBar;
import view.element.TurtleView;
import view.element.ViewElement;

import java.util.List;

public class ViewViewController extends InteractionController {

    protected ViewViewController(List<ViewElement> elements) {
        super(elements);
    }

    @Override
    public void setUpInteractions() {
        setBackgroundColorChanger();
    }

    private void setBackgroundColorChanger() {
        if (getElementByClass("SettingsToolBar") == null || getElementByClass("TurtleView") == null) {
            System.out.println("HM");
            return;
        }
        System.out.println("EY");
        SettingsToolBar toolBar = (SettingsToolBar)getElementByClass("SettingsToolBar");
        TurtleView turtleView = (TurtleView)getElementByClass("TurtleView");
        toolBar.setBackgroundColorPickerHandler(event -> {
            turtleView.setBackgroundColor(toolBar.getSelectedBackgroundColor());
        });
    }
}
