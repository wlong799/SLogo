package view;

import javafx.scene.Parent;
import view.element.Viewable;

import java.util.List;

public interface ContentManager {

    Parent getContentLayout();

    List<Viewable> getElements();
}
