package dataStorage;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.util.*;


public class ColorStorage {
    private Map<Integer, Map<String, Integer>> myColorMap;
    private static final int DEFAULT_RETURN = 0;
    private static final String RESOURCE_PACKAGE = "resources/xmlNaming";
    private ResourceBundle myResources;
    private String language = "English";
    private ObservableList<Integer> myColor;
    private static final String COLOR_PATHS = "resources/colors";


    public ColorStorage() {
        myColorMap = new HashMap<>();
        init();
        myResources = ResourceBundle.getBundle(RESOURCE_PACKAGE + language);
        myColor = FXCollections.observableArrayList();

    }

    private void init () {
        myColor.addAll(255, 255, 255);
        ResourceBundle defaultColors = ResourceBundle.getBundle(COLOR_PATHS);
        for (String s : defaultColors.keySet()) {
            String colorList = defaultColors.getString(s);
            String[] rgb = colorList.split(",");
            Map<String, Integer> colorComponents = new HashMap<>();
            colorComponents.put(myResources.getString("color_red"), Integer.parseInt(rgb[0]));
            colorComponents.put(myResources.getString("color_green"), Integer.parseInt(rgb[1]));
            colorComponents.put(myResources.getString("color_blue"), Integer.parseInt(rgb[2]));
            myColorMap.put(Integer.parseInt(s), colorComponents);
        }
    }


    public Map<String, Integer> getColor(int index) {
        try {
            return myColorMap.get(index);
        }
        catch(Exception e) {
            e.printStackTrace();
            // TODO: How can I access the Notifications to set a colorNotSpecifiedFlag?
            Map<String, Integer> colorComponents = new HashMap<>();
            colorComponents.put(myResources.getString("color_red"), DEFAULT_RETURN);
            colorComponents.put(myResources.getString("color_green"), DEFAULT_RETURN);
            colorComponents.put(myResources.getString("color_blue"), DEFAULT_RETURN);
            return colorComponents;
        }
    }
    public void addColor(int index, int red, int green, int blue) {
        Map<String, Integer> colorComponents = new HashMap<>();
        colorComponents.put(myResources.getString("color_red"), red);
        colorComponents.put(myResources.getString("color_green"), green);
        colorComponents.put(myResources.getString("color_blue"), blue);
        myColorMap.put(index, colorComponents);
    }

    public void setColor (int index) {
        if (myColorMap.containsKey(index)) {
            myColor.clear();
            for(String key : myColorMap.get(index).keySet()) {
                myColor.add(myColorMap.get(index).get(key));
            }
        }
    }


    public Map<Integer, Map<String, Integer>> getColorMap() {
        return myColorMap;
    }

}