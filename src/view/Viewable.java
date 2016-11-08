package view;

import javafx.scene.Node;

/**
 * Classes that implement Viewable have JavaFX content that can be accessed through the getContent method. Ideally, this
 * provides a way for classes to not have to extend the JavaFX API, and minimizes the manner in which classes expose
 * their internal JavaFX framework. This makes it easier to switch to other GUI frameworks in the future if necessary.
 * By simply returning a Node as well, it means that classes using the content (i.e. classes simply setting layout of
 * the scene), don't have specific JavaFX sub-classes to work with, and are thus less likely to try to use the content
 * beyond setting its position in the screen.
 *
 * @author Will Long
 */
public interface Viewable {
    /**
     * Returns the content contained within the Viewable.
     *
     * @return a JavaFX Node.
     */
    Node getContent();
}
