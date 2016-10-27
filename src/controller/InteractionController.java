package controller;

import view.element.Viewable;

import java.util.List;

/**
 * Takes in elements present in view, and is responsible for setting up how
 * they interact with each other, and possibly how they interact with other
 * parts of the program
 */
public abstract class InteractionController {

    protected List<Viewable> viewables;

    protected InteractionController(List<Viewable> elements) {
        viewables = elements;
    }

    public abstract void setUpInteractions();

    protected Viewable getElementByClass(String className) {
        for (Viewable element : viewables) {
            if (checkClass(element, className)) {
                return element;
            }
        }
        return null;
    }

    protected boolean checkClass(Viewable element, String className) {
        return element.getClass().getSimpleName().equals(className);
    }
}
