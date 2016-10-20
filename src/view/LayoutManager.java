package view;

import javafx.scene.Parent;

import java.util.List;

/**
 * Interface to provide a common way for different classes to provide different layouts of the
 * elements in the GUI. setComponentLayout takes in a list of ViewElements to be placed in the
 * application, and determines how they are laid out, returning a Parent object containing the
 * elements. Using an interface will allow for us to experiment with different application
 * layouts easily.
 */
public interface LayoutManager {
    public abstract Parent setComponentLayout(List<ViewElement> viewElements);
}
