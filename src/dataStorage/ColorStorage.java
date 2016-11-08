package dataStorage;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.util.*;


/**
 * This class is used to store all of the color preferences for the back end. This includes both pen
 * color and background color. This is accessed via the DataStorageManager in the commands that
 * change these values, and by the front end as well. It extends Observable so that the front end is
 * able to update the appropriate values whenever there is a change in the back end.
 * 
 * @author Michael Schroeder
 */
public class ColorStorage extends Observable {
    private static final String COLOR_SEPARATOR = ",";
    private static final String COLOR_PATHS = "resources/colors";
    private Map<Integer, String> myColorMap;
    private ObservableList<String> myColorList;
    private double myPenSize;
    private String myPenColor;
    private String myBackgroundColor;

    public ColorStorage () {
        myColorMap = new HashMap<>();
        myColorList = FXCollections.observableArrayList();
        init();
    }

    private void init () {

        ResourceBundle defaultColors = ResourceBundle.getBundle(COLOR_PATHS);
        for (String s : defaultColors.keySet()) {
            String colorString = addRGB(defaultColors.getString(s));

            myColorMap.put(Integer.parseInt(s), colorString);
            myColorList.add(s + " " + colorString);
        }
        myPenColor = myColorMap.get(0);
        myBackgroundColor = myColorMap.get(1);
        //// System.out.println(myColorMap.values());
    }

    private String addRGB (String color) {
        StringBuilder colorString = new StringBuilder();
        colorString.append("rgb(");
        colorString.append(color);
        colorString.append(")");
        return colorString.toString();

    }

    public String getColor (int index) {
        return myColorMap.containsKey(index) ? myColorMap.get(index) : myColorMap.get(0);
    }

    private String toColorString (int red, int green, int blue) {
        StringBuilder colorBuilder = new StringBuilder();
        colorBuilder.append(red);
        colorBuilder.append(COLOR_SEPARATOR);
        colorBuilder.append(green);
        colorBuilder.append(COLOR_SEPARATOR);
        colorBuilder.append(blue);
        return addRGB(colorBuilder.toString());
    }

    public void addColor (int index, int red, int green, int blue) {

        if (myColorMap.containsKey(index)) {
            myColorList.remove(index + " " + myColorMap.get(index));
        }
        String colorString = toColorString(red, green, blue);
        myColorMap.put(index, colorString);
        // ////System.out.println(myColorMap.values());
        myColorList.add(index + " " + colorString);
        //// System.out.println(myColorList + " color list");
    }

    public void setPenColor (int index) {
        if (myColorMap.containsKey(index)) {
            myPenColor = myColorMap.get(index);
        }
        updateObservers();
    }

    public void setBackgroundColor (int index) {
        if (myColorMap.containsKey(index)) {
            myBackgroundColor = myColorMap.get(index);
        }
        updateObservers();
    }

    public int getColorIndex () {
        for (Map.Entry<Integer, String> e : myColorMap.entrySet()) {
            if (e.getValue().equals(myPenColor)) {
                return e.getKey();
            }
        }
        return 0;
    }

    public Map<Integer, String> getColorMap () {
        return myColorMap;
    }

    public ObservableList<String> getColorList () {
        return myColorList;
    }

    public void setPenSize (double penSize) {
        myPenSize = penSize;
        updateObservers();
    }

    private void updateObservers () {
        setChanged();
        notifyObservers(new String[] { myBackgroundColor, myPenColor,
                                       Double.toString(myPenSize) });
    }

}
