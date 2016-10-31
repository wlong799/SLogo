package view.toolbar;

import javafx.scene.control.*;
import javafx.scene.image.Image;
import view.Style;
import view.Stylizable;
import view.Stylizer;

import java.util.HashMap;
import java.util.Map;

public class TurtleImagePicker extends MenuElement implements Stylizer {
    private static final String NAME = "Select Turtle Image";
    private static final String DEFAULT_IMAGE = "Turtle";
    private static final String[] IMAGE_NAMES = new String[]
            {"Turtle", "Smiley Face"};
    private static final String[] IMAGE_LOCATIONS = new String[]
            {"resources/turtle.png", "resources/smiley.png"};
    private Map<String, Image> myImageMap;

    private Menu myMenu;
    private ToggleGroup myImageGroup;

    public TurtleImagePicker() {
        myMenu = new Menu(NAME);
        myImageGroup = new ToggleGroup();
        myImageMap = new HashMap<>();
        for (int i = 0; i < IMAGE_NAMES.length; i++) {
            String imageName = IMAGE_NAMES[i];
            Image image = new Image(IMAGE_LOCATIONS[i]);
            myImageMap.put(imageName, image);

            RadioMenuItem myRadioItem = new RadioMenuItem(imageName);
            myRadioItem.setUserData(image);
            myRadioItem.setToggleGroup(myImageGroup);
            myMenu.getItems().add(myRadioItem);
        }
    }

    @Override
    public MenuItem getMenuItem(){
        return myMenu;
    }

    @Override
    public void setStylizableTarget(Stylizable stylizableTarget) {
        myImageGroup.selectedToggleProperty().addListener((observable, oldValue, newValue) -> {
            if (myImageGroup.getSelectedToggle() != null) {
                Image image = (Image) myImageGroup.getSelectedToggle().getUserData();
                Style style = new Style(image);
                stylizableTarget.setStyle(style);
            }
        });
    }
}
