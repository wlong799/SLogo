package dataStorage;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;


public class ColorStorage {
    private Map<Integer, Map<String, Integer>> myColorMap;
    private static final int DEFAULT_RETURN = 0;
    private static final String RESOURCE_PACKAGE = "resources/xmlNaming";
    private ResourceBundle myResources;
    private String language = "English";
    private ObservableList<Integer> myColor;



    public ColorStorage() {
        myColorMap = new HashMap<>();
//        colorMap = importDefaultColorsFromFile();
        myResources = ResourceBundle.getBundle(RESOURCE_PACKAGE + language);
        myColor = FXCollections.observableArrayList();

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
//    private Map<Integer, Map<String, Double>> importDefaultColorsFromFile() {
//        /* TODO: Set up a default colors file, maybe. Or just make like three colors here locally and not
//        * deal with the XML file here.
//        */
//    }
}