package view;

import java.util.ArrayList;
import java.util.List;

/**
 * Responsible for storing all current elements present within the GUI, and providing access to them.
 */
public class ViewElementManager {
    private List<Viewable> myViewElements;

    public ViewElementManager() {
        myViewElements = new ArrayList<>();
    }

    public void addElement(Viewable element) {
        myViewElements.add(element);
    }

    public Viewable getElement(String className) {
        for (Viewable element : myViewElements) {
            if (checkClass(element, className)) {
                return element;
            }
        }
        return null;
    }

    private boolean checkClass(Viewable element, String className) {
        return element.getClass().getSimpleName().equals(className);
    }
}
