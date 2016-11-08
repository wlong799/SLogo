package view;

import javafx.scene.Parent;
import javafx.scene.layout.Pane;
import view.start.StartButtons;
import view.start.StartScreen;

/**
 * ContentManager responsible for setting up the initial splash screen. Provides a background logo and two options for
 * either creating a new workspace or loading one from file.
 *
 * @author Will Long
 */
public class StartContent implements ContentManager {
    private static final double BUTTON_PANE_OFFSET_RATIO = 0.80;
    private static final double BUTTON_PANE_WIDTH_RATIO = 0.25;
    private static final double BUTTON_PANE_HEIGHT_RATIO = 0.05;

    private double myWidth, myHeight;
    private double myPaneWidth, myPaneHeight;

    private Pane myStartContent;
    private ElementManager myViewElements;

    /**
     * Creates a new splash screen of the specified size.
     * @param width is width of screen.
     * @param height is height of screen.
     */
    public StartContent(double width, double height) {
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
    public Parent getContentLayout() {
        return myStartContent;
    }

    @Override
    public ElementManager getElements() {
        return myViewElements;
    }

    private Pane createCenteredButtonPane(StartButtons startButtons) {
        Pane pane = new Pane(startButtons.getContent());
        double widthOffset = (myWidth - myPaneWidth) / 2;
        double heightOffset = (myHeight * BUTTON_PANE_OFFSET_RATIO);
        pane.setLayoutX(widthOffset);
        pane.setLayoutY(heightOffset);
        return pane;
    }
}
