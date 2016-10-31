import dataStorage.*;

import java.util.*;

public class XmlDataSetter {
    private static final int ONLY_ITEM = 0;
    private static final String RESOURCE_PACKAGE = "resources/xmlNaming";

    private ResourceBundle myResources;

    public XmlDataSetter(String language) {
        myResources = ResourceBundle.getBundle(RESOURCE_PACKAGE + language);
    }


    /**
     *
     * @param turtleMap: given only the part of the parsed map which is "turtle_storage"
     * @return
     */
    public TurtleStorage setTurtles(Map<String, Map<String, String>> turtleMap) {

        TurtleStorage newTurtleStorage = new TurtleStorage();

        for(String oneTurtleKey : turtleMap.keySet()) {
            Map<String, String> oneTurtleMap = turtleMap.get(oneTurtleKey);
            List<Integer> oneID = new ArrayList<>();
            oneID.add(Integer.parseInt(oneTurtleMap.get("id")));

            newTurtleStorage.setActiveTurtles(oneID);  // makes the one turtle specified

            Turtle oneTurtle = newTurtleStorage.getTurtle(oneID.get(ONLY_ITEM));

            // set Position
            Position turtlePosition = new Position(
                    Double.parseDouble(oneTurtleMap.get("x")),
                    Double.parseDouble(oneTurtleMap.get("y"))
            );

            oneTurtle.setPosition(turtlePosition);

            // set Heading
            oneTurtle.setHeading(Double.parseDouble(oneTurtleMap.get("heading")));

            // set penDown
            oneTurtle.setPenDownStatus(Boolean.getBoolean(oneTurtleMap.get("pen_down")));

            oneTurtle.setPenColor(Double.parseDouble(oneTurtleMap.get("pen_color")));

            oneTurtle.setPenSize(Double.parseDouble(oneTurtleMap.get("pen_size")));

            oneTurtle.setVisibility(Boolean.getBoolean(oneTurtleMap.get("visible")));

            oneTurtle.setShape(Double.parseDouble(oneTurtleMap.get("shape")));
        }

        return newTurtleStorage;
    }

    public ColorStorage setColors(Map<String, Map<String, String>> colorMap) {
        ColorStorage newColorStorage = new ColorStorage();

        for(String oneColorKey : colorMap.keySet()) {
            Map<String, String> oneColorMap = colorMap.get(oneColorKey);
            newColorStorage.addColor(
                    Integer.parseInt(oneColorMap.get("index")),
                    Integer.parseInt(oneColorMap.get("red")),
                    Integer.parseInt(oneColorMap.get("green")),
                    Integer.parseInt(oneColorMap.get("blue"))
            );
        }
        return newColorStorage;
    }

    public VariableStorage setValueVariables(Map<String, Map<String, String>> valueVariableMap) {
        VariableStorage newValueVariableStorage = new VariableStorage();

        for(String oneVariableKey : valueVariableMap.keySet()) {
            Map<String, String> oneValueVariableMap = valueVariableMap.get(oneVariableKey);

            newValueVariableStorage.setVariable(
                    oneValueVariableMap.get("name"),
                    Double.parseDouble(oneValueVariableMap.get("value"))
            );
        }

        return newValueVariableStorage;
    }

    public CommandStorage setCommandVariables(Map<String, Map<String, String>> commandVariableMap) {
        CommandStorage newCommandVariableStorage = new CommandStorage();

        for(String oneVariableKey : commandVariableMap.keySet()) {
            Map<String, String> oneCommandVariableMap = commandVariableMap.get(oneVariableKey);

            List<String> parameterList = Arrays.asList(oneCommandVariableMap.get("parameters").split(" "));

            newCommandVariableStorage.setCommand(
                    oneCommandVariableMap.get("name"),
                    parameterList,
                    oneCommandVariableMap.get("body")
            );

        }
        return newCommandVariableStorage;
    }

}
