package controller;

import view.element.*;

import java.util.List;

public class ViewViewController extends InteractionController {

    protected ViewViewController(List<ViewElement> elements) {
        super(elements);
    }

    @Override
    public void setUpInteractions() {
        setBackgroundColorChanger();
        setLineColorChanger();
        setClickableCommandHistory();
    }

    private void setClickableCommandHistory() {
        if (getElementByClass("CommandHistoryWindow") == null || getElementByClass("TextEntryBox") == null) {
            return;
        }
        CommandHistoryWindow chWindow = (CommandHistoryWindow)getElementByClass("CommandHistoryWindow");
        TextEntryBox textBox = (TextEntryBox)getElementByClass("TextEntryBox");
        chWindow.setClickEvent(event -> {
            String selectedCommand= chWindow.getSelectedCommand();
            textBox.setText(selectedCommand);
        });
    }

    private void setLineColorChanger(){
    	if (getElementByClass("SettingsToolBar") == null || getElementByClass("TurtleView") == null) {
            System.out.println("HM");
            return;
        }
    	SettingsToolBar toolBar = (SettingsToolBar)getElementByClass("SettingsToolBar");
        TurtleView turtleView = (TurtleView)getElementByClass("TurtleView");
        toolBar.setLineColorPickerHandler(event -> {
            turtleView.setLineColor(toolBar.getSelectedLineColor());
        });
    	
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
