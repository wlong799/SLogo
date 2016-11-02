package view;

import view.panel.TabElement;

import java.util.ArrayList;
import java.util.List;
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

    public Stylizable getStylizableElement(String className) {
        Object element = getGUIElement(className);
        if (element == null || !(element instanceof Stylizable)) {
            return null;
        }
        return (Stylizable) element;
    }

    public Stylizer getStylizerElement(String className) {
        Object element = getGUIElement(className);
        if (element == null || !(element instanceof Stylizer)) {
            return null;
        }
        return (Stylizer) element;
    }

    public TabElement getTabElement(String className) {
        Object element = getGUIElement(className);
        if (element == null || !(element instanceof TabElement)) {
            return null;
        }
        return (TabElement) element;
    }

    public List<Commander> getCommanderElements() {
        return myElements.stream().filter(object -> object instanceof Commander).map(
                object -> (Commander) object).collect(Collectors.toList());
    }

    public List<WorkspaceInteractor> getWorkspaceInteractorElements() {
        return myElements.stream().filter(object -> object instanceof WorkspaceInteractor).map(
                object -> (WorkspaceInteractor) object).collect(Collectors.toList());
    }

    public List<AnimationController> getAnimationControllerElements() {
        return myElements.stream().filter(object -> object instanceof AnimationController).map(
                object -> (AnimationController) object).collect(Collectors.toList());
    }

    public Object getGUIElement(String className) {
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
