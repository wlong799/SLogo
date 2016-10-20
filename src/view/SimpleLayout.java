package view;

import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import sun.java2d.pipe.SpanShapeRenderer;

import java.util.List;

/**
 * SimpleLayout just provides a quick setup for the application. Non-resizable, and provides a
 * TurtleView, with a TextEntryBox beneath.
 */
public class SimpleLayout implements LayoutManager{
    private static final double DEFAULT_WIDTH = 1000;
    private static final double DEFAULT_HEIGHT = 750;

    private Group root;
    private double myWidth;
    private double myHeight;

    public SimpleLayout() {
        this(DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }

    public SimpleLayout(double width, double height) {
        root = new Group();
        myWidth = width;
        myHeight = height;
    }

    @Override
    public Parent setComponentLayout(List<ViewElement> viewElements) {
        for (ViewElement v : viewElements) {
            if (v.getClass().getSimpleName().equals("TurtleView")) {
                Node turtleView = v.getContent();
                turtleView.setLayoutX(0);
                turtleView.setLayoutY(0);
                root.getChildren().add(turtleView);
            }
            if (v.getClass().getSimpleName().equals("TextEntryBox")) {
                Node textEntryBox = v.getContent();
                textEntryBox.setLayoutX(0);
                textEntryBox.setLayoutY(myHeight-100);
            }
        }
        return root;
    }
}
