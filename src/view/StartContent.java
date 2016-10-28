package view;

import javafx.scene.Parent;
import javafx.scene.layout.Pane;
<<<<<<< HEAD
import view.start.StartButtons;
import view.start.StartScreen;
=======
import view.element.StartButtons;
import view.element.StartScreen;
import view.element.Viewable;
import java.util.ArrayList;
import java.util.List;
>>>>>>> master


public class StartContent implements ContentManager {
    private static final double BUTTON_PANE_OFFSET_RATIO = 0.80;
    private static final double BUTTON_PANE_WIDTH_RATIO = 0.25;
    private static final double BUTTON_PANE_HEIGHT_RATIO = 0.05;

    private double myWidth, myHeight;
    private double myPaneWidth, myPaneHeight;

    private Pane myStartContent;
    private ElementManager myViewElements;

    public StartContent (double width, double height) {
        myWidth = width;
        myHeight = height;
        myPaneWidth = myWidth * BUTTON_PANE_WIDTH_RATIO;
        myPaneHeight = myHeight * BUTTON_PANE_HEIGHT_RATIO;

        myViewElements = new ElementManager();

        StartScreen startScreen = new StartScreen(myWidth, myHeight);
        StartButtons startButtons = new StartButtons(myPaneWidth, myPaneHeight);
        myViewElements.addElement(startScreen);
        myViewElements.addElement(startButtons);

        myStartContent = new Pane(startScreen.getContent(), createCenteredButtonPane(startButtons));
    }

    @Override
    public Parent getContentLayout () {
        return myStartContent;
    }

    @Override
    public ElementManager getElements() {
        return myViewElements;
    }
    private Pane createCenteredButtonPane (StartButtons startButtons) {
        Pane pane = new Pane(startButtons.getContent());
        double widthOffset = (myWidth - myPaneWidth) / 2;
        double heightOffset = (myHeight * BUTTON_PANE_OFFSET_RATIO);
        pane.setLayoutX(widthOffset);
        pane.setLayoutY(heightOffset);
        return pane;
    }
}
