package view;

import javafx.scene.Parent;

public interface ContentManager {

    Parent getContentLayout();

    ViewElementManager getElements();
}
