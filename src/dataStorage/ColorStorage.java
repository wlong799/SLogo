package dataStorage;


import java.util.HashMap;
import java.util.Map;

public class ColorStorage {
    private Map<Integer, Map<String, Double>> colorMap;
    private static final double DEFAULT_RETURN = 0;

    public ColorStorage() {
        colorMap = importDefaultColorsFromFile();
    }

    public Map<String, Double> getColor(int index) {
        try {
            return colorMap.get(index);
        }
        catch(Exception e) {
            e.printStackTrace();
            // TODO: How can I access the Notifications to set a colorNotSpecifiedFlag?
            Map<String, Double> colorComponents = new HashMap<>();
            colorComponents.put("red", DEFAULT_RETURN);
            colorComponents.put("green", DEFAULT_RETURN);
            colorComponents.put("blue", DEFAULT_RETURN);
            return colorComponents;
        }
    }

    public void setColor(int index, double red, double green, double blue) {
        Map<String, Double> colorComponents = new HashMap<>();
        colorComponents.put("red", red);
        colorComponents.put("green", green);
        colorComponents.put("blue", blue);
        colorMap.put(index, colorComponents);
    }

    private Map<Integer, Map<String, Double>> importDefaultColorsFromFile() {
        /* TODO: Set up a default colors file, maybe. Or just make like three colors here locally and not
        * deal with the XML file here.
        */
    }
}
