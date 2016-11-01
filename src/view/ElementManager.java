package view;

import view.toolbar.MenuElement;

import java.util.ArrayList;
import java.util.List;

/**
 * Responsible for storing all current elements present within the GUI, and providing access to them.
 */
public class ElementManager {
    private List<Object> myElements;

    public ElementManager() {
        myElements = new ArrayList<>();
    }

    public void addElement(Object element) {
        myElements.add(element);
    }

    public GUIElement getGUIElement(String className) {
        Object element = getElement(className);
        if (element == null || !(element instanceof GUIElement)) {
            return null;
        }
        return (GUIElement) element;
    }

    public Stylizable getStylizableElement(String className) {
        Object element = getElement(className);
        if (element == null || ! (element instanceof Stylizable)) {
            return null;
        }
        return (Stylizable)element;
    }

    public Stylizer getStylizerElement(String className) {
        Object element = getElement(className);
        if (element == null || ! (element instanceof Stylizer)) {
            return null;
        }
        return (Stylizer) element;
    }

    public Commander getCommanderElement(String className) {
        Object element = getElement(className);
        if (element == null || ! (element instanceof Commander)) {
            return null;
        }
        return (Commander) element;
    }

    private Object getElement(String className) {
        for (Object element : myElements) {
            if (checkClass(element, className)) {
                return element;
            }
        }
        return null;
    }

    private boolean checkClass(Object element, String className) {
        return element.getClass().getSimpleName().equals(className);
    }
}
