package controller;

import view.ViewElementManager;

/**
 * Takes in elements present in view, and is responsible for setting up how
 * they interact with each other, and possibly how they interact with other
 * parts of the program
 */
public abstract class InteractionController {

    protected ViewElementManager myViewElements;

    protected InteractionController(ViewElementManager viewElements) {
        myViewElements = viewElements;
    }

    public abstract void setUpInteractions();
}
