package dataStorage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.image.Image;


public class ColorStorage {

    private static final String COLOR_PATHS = "resources/colors";
    private Map<Integer, List<Integer>> myColorMap;
    private ObservableList<Integer> myColor;

    public ColorStorage () {
        myColorMap = new HashMap<Integer, List<Integer>>();
        myColor = FXCollections.observableArrayList();
        init();
    }

    private void init () {
        myColor.addAll(255, 255, 255);
        ResourceBundle defaultColors = ResourceBundle.getBundle(COLOR_PATHS);
        for (String s : defaultColors.keySet()) {
            String colorList = defaultColors.getString(s);
            String[] rgb = colorList.split(",");
            List<Integer> rgbList = new ArrayList<Integer>();
            rgbList.add(Integer.parseInt(rgb[0]));
            rgbList.add(Integer.parseInt(rgb[1]));
            rgbList.add(Integer.parseInt(rgb[2]));
            myColorMap.put(Integer.parseInt(s), rgbList);
        }
    }

    public void setColor (int index) {
        if (myColorMap.containsKey(index)) {
            myColor.clear();
            myColor.addAll(myColorMap.get(index));
        }
    }

    public ObservableList<Integer> getColor () {
        return myColor;
    }
}
