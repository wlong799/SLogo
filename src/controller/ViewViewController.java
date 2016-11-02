package controller;

import view.ElementManager;

import view.Stylizable;
import view.Stylizer;
import view.panel.CommandHistoryWindow;
import view.panel.StoredFunctionWindow;
import view.textbox.TextEntryBox;

public class ViewViewController extends InteractionController {
    private static final String[][] STYLE_ELEMENTS_TO_LINK = new String[][]
            {
                    {"BackgroundColorPicker", "TurtleContainer"},
                    {"LineColorPicker", "TurtleManager"},
                    {"LineStylePicker", "TurtleManager"},
                    {"LineSizePicker", "TurtleManager"},
                    {"PenDownToggle", "TurtleManager"},
                    {"TurtleImagePicker", "TurtleManager"},
                    {"CustomTurtleImageInput", "TurtleManager"}
            };

    public ViewViewController(ElementManager viewElements) {
        super(viewElements);
    }

    @Override
    public void setUpInteractions() {
        for (String[] linkedElements : STYLE_ELEMENTS_TO_LINK) {
            Stylizer stylizer = myViewElements.getStylizerElement(linkedElements[0]);
            Stylizable stylizable = myViewElements.getStylizableElement(linkedElements[1]);
            if (stylizer != null && stylizable != null) {
                stylizer.setStylizableTarget(stylizable);
            }
        }
    }

}
