package controller;

import view.ElementManager;
import view.start.StartButtons;

/**
 * @author Will Long
 * @version 10/26/16
 */
public class StartController extends InteractionController{

    SLogoController myController;

    public StartController(ElementManager viewElements, SLogoController controller) {
        super(viewElements);
        myController = controller;
    }

    @Override
    public void setUpInteractions() {
        StartButtons buttons = (StartButtons)myViewElements.getGUIElement("StartButtons");
        buttons.setStartEvent(event -> {
            myController.createNewWorkspace();
            myController.loadCurrentWorkspace();
        });
    }
}
