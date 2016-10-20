package controller;

import view.element.TextEntryBox;
import view.element.TurtleView;
import view.element.ViewElement;

import java.util.List;

/**
 * Takes in elements present in view, and is responsible for setting up how
 * they interact with each other, and possibly how they interact with other
 * parts of the program
 */
public abstract class InteractionController {

    protected List<ViewElement> viewElements;

    protected InteractionController(List<ViewElement> elements) {
        viewElements = elements;
    }

    public abstract void setUpInteractions();

    protected ViewElement getElementByClass(String className) {
        for (ViewElement element : viewElements) {
            if (checkClass(element, className)) {
                return element;
            }
        }
        return null;
    }

    protected boolean checkClass(ViewElement element, String className) {
        return element.getClass().getSimpleName().equals(className);
    }
}
