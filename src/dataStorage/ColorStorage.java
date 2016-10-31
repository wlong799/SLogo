package dataStorage;


import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

public class ColorStorage {
    private Map<Integer, Map<String, Double>> colorMap;
    private static final double DEFAULT_RETURN = 0;

    private static final String RESOURCE_PACKAGE = "resources/xmlNaming";
    private ResourceBundle myResources;
    private String language = "English";

    public ColorStorage() {
        colorMap = new HashMap<>();
//        colorMap = importDefaultColorsFromFile();
        myResources = ResourceBundle.getBundle(RESOURCE_PACKAGE + language);
    }

    public Map<String, Double> getColor(int index) {
        try {
            return colorMap.get(index);
        }
        catch(Exception e) {
            e.printStackTrace();
            // TODO: How can I access the Notifications to set a colorNotSpecifiedFlag?
            Map<String, Double> colorComponents = new HashMap<>();
            colorComponents.put(myResources.getString("color_red"), DEFAULT_RETURN);
            colorComponents.put(myResources.getString("color_green"), DEFAULT_RETURN);
            colorComponents.put(myResources.getString("color_blue"), DEFAULT_RETURN);
            return colorComponents;
        }
    }

    public void setColor(int index, double red, double green, double blue) {
        Map<String, Double> colorComponents = new HashMap<>();
        colorComponents.put(myResources.getString("color_red"), red);
        colorComponents.put(myResources.getString("color_green"), green);
        colorComponents.put(myResources.getString("color_blue"), blue);
        colorMap.put(index, colorComponents);
    }

    public Map<Integer, Map<String, Double>> getColorMap() {
        return colorMap;
    }

//    private Map<Integer, Map<String, Double>> importDefaultColorsFromFile() {
//        /* TODO: Set up a default colors file, maybe. Or just make like three colors here locally and not
//        * deal with the XML file here.
//        */
//    }
}
