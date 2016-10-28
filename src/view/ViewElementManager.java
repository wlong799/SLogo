package view;

import java.util.ArrayList;
import java.util.List;

/**
 * Responsible for storing all current elements present within the GUI, and providing access to them.
 */
public class ViewElementManager {
    private List<ViewElement> myViewElements;

    public ViewElementManager() {
        myViewElements = new ArrayList<>();
    }

    public void addElement(ViewElement element) {
        myViewElements.add(element);
    }

    public ViewElement getElement(String className) {
        for (ViewElement element : myViewElements) {
            if (checkClass(element, className)) {
                return element;
            }
        }
        return null;
    }

    private boolean checkClass(ViewElement element, String className) {
        return element.getClass().getSimpleName().equals(className);
    }
}
