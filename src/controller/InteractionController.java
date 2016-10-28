package controller;

import view.ElementManager;

/**
 * Takes in elements present in view, and is responsible for setting up how
 * they interact with each other, and possibly how they interact with other
 * parts of the program
 */
public abstract class InteractionController {

    protected ElementManager myViewElements;

    protected InteractionController(ElementManager viewElements) {
        myViewElements = viewElements;
    }

    public abstract void setUpInteractions();
}
