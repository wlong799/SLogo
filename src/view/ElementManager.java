package view;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

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
        if (element == null || !(element instanceof Stylizable)) {
            return null;
        }
        return (Stylizable) element;
    }

    public Stylizer getStylizerElement(String className) {
        Object element = getElement(className);
        if (element == null || !(element instanceof Stylizer)) {
            return null;
        }
        return (Stylizer) element;
    }

    public List<Commander> getCommanderElements() {
        return myElements.stream().filter(object -> object instanceof Commander).map(
                object -> (Commander)object).collect(Collectors.toList());
    }

    public WorkspaceInteractor getWorkspaceInteractorElement(String className) {
        Object element = getElement(className);
        if (element == null || !(element instanceof WorkspaceInteractor)) {
            return null;
        }
        return (WorkspaceInteractor) element;
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
