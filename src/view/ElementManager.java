package view;

import view.panel.TabElement;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Responsible for storing all current elements present within the GUI, and methods for accessing them, based on the
 * functionality that they provide. This class provides the controller classes with a simple interface for accessing
 * elements in the view, regardless of how they look or how they're positioned.
 *
 * @author Will Long
 */
public class ElementManager {
    private List<Object> myElements;

    public ElementManager() {
        myElements = new ArrayList<>();
    }

    /**
     * Add a new view element to the list of available elements.
     *
     * @param element is the view element to add.
     */
    public void addElement(Object element) {
        myElements.add(element);
    }

    /**
     * Returns a Stylizable object from current elements.
     *
     * @param className is name of class of Stylizable.
     * @return the Stylizable if it is present, null otherwise.
     */
    public Stylizable getStylizableElement(String className) {
        Object element = getGUIElement(className);
        if (element == null || !(element instanceof Stylizable)) {
            return null;
        }
        return (Stylizable) element;
    }

    /**
     * Returns a Stylizer object from current elements.
     *
     * @param className is name of class of Stylizer.
     * @return the Stylizer if it is present, null otherwise.
     */
    public Stylizer getStylizerElement(String className) {
        Object element = getGUIElement(className);
        if (element == null || !(element instanceof Stylizer)) {
            return null;
        }
        return (Stylizer) element;
    }

    /**
     * Returns a TabElement object from current elements.
     *
     * @param className is name of class of TabElement.
     * @return the TabElement if it is present, null otherwise.
     */
    public TabElement getTabElement(String className) {
        Object element = getGUIElement(className);
        if (element == null || !(element instanceof TabElement)) {
            return null;
        }
        return (TabElement) element;
    }

    /**
     * Return all current Commanders.
     *
     * @return list of all stored Commander elements.
     */
    public List<Commander> getCommanderElements() {
        return myElements.stream().filter(object -> object instanceof Commander).map(
                object -> (Commander) object).collect(Collectors.toList());
    }

    /**
     * Return all current WorkspaceInteractors.
     *
     * @return list of all stored WorkspaceInteractor elements.
     */
    public List<WorkspaceInteractor> getWorkspaceInteractorElements() {
        return myElements.stream().filter(object -> object instanceof WorkspaceInteractor).map(
                object -> (WorkspaceInteractor) object).collect(Collectors.toList());
    }

    /**
     * Return all current AnimationControllers.
     *
     * @return list of all stored AnimationController elements.
     */
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
