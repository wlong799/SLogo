package controller;

import view.ViewElementManager;
import view.start.StartButtons;

/**
 * @author Will Long
 * @version 10/26/16
 */
public class StartController extends InteractionController{

    SLogoController myController;

    public StartController(ViewElementManager viewElements, SLogoController controller) {
        super(viewElements);
        myController = controller;
    }

    @Override
    public void setUpInteractions() {
        StartButtons buttons = (StartButtons)myViewElements.getElement("StartButtons");
        buttons.setStartEvent(event -> {
            myController.createNewWorkspace();
            myController.loadCurrentWorkspace();
        });
    }
}
