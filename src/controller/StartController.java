package controller;

import view.element.StartButtons;
import view.element.Viewable;

import java.util.List;

/**
 * @author Will Long
 * @version 10/26/16
 */
public class StartController extends InteractionController{

    SLogoController myController;

    public StartController(List<Viewable> elements, SLogoController controller) {
        super(elements);
        myController = controller;
    }

    @Override
    public void setUpInteractions() {
        StartButtons buttons = (StartButtons)getElementByClass("StartButtons");
        buttons.setStartEvent(event -> {
            myController.newWorkspace();
        });
    }
}
