package view.element;

import javafx.scene.Node;

/**
 * Interface for all elements within the GUI to implement. It allows for other classes to access the
 * components of the GUI in a more general fashion, and makes the code flexible by only specifying
 * the content to be a node. This makes it very easy to change how the individual elements are
 * actually implemented (as opposed to extending the JavaFX codebase).
 */
public interface ViewElement {
    Node getContent();
}
