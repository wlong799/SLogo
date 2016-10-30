import dataStorage.TurtleStorage;
import javafx.beans.binding.IntegerBinding;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class XmlDataSetter {


    /**
     *
     * @param turtleMap: given only the part of the parsed map which is "turtle_storage"
     * @return
     */
    public TurtleStorage setTurtles(Map<String, Object> turtleMap) {
        TurtleStorage newTurtleStorage = new TurtleStorage();
        List<Integer> allID = new ArrayList<>();

        for(String oneTurtleKey : turtleMap.keySet()) {
            Map<String, String> oneTurtleMap = (Map<String, String>) turtleMap.get(oneTurtleKey);

            allID.add(Integer.parseInt(oneTurtleMap.get("id")));
        }

        newTurtleStorage.setActiveTurtles(allID);

        




        return newTurtleStorage;
    }

}
