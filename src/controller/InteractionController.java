package controller;

import view.ElementManager;

/**
 * Abstract superclass provides way for different controllers to set up interactions within the view and with the model.
 * Takes in an ElementManager corresponding with all elements available in view. Different implementations set up
 * interactions differently depending on their focus.
 *
 * @author Will Long
 */
public abstract class InteractionController {

    protected ElementManager myViewElements;

    protected InteractionController(ElementManager viewElements) {
        myViewElements = viewElements;
    }

    public abstract void setUpInteractions();
}
