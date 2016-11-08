package view;

import javafx.scene.Parent;

/**
 * Classes that implement ContentManager are responsible for organizing the layout of elements in the view, and for
 * setting all the elements that will be available to controller.
 *
 * @author Will Long
 */
public interface ContentManager {

    /**
     * Returns the content of the view, to be displayed within the main scene of the application.
     *
     * @return the root node for the view content.
     */
    Parent getContentLayout();

    /**
     * Returns all available elements within the view, to be accessed by the controller classes.
     *
     * @return an ElementManager containing all available elements.
     */
    ElementManager getElements();
}
