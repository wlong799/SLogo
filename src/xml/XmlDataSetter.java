package xml;

import controller.workspace.WorkspaceLoadPreferences;
import dataStorage.*;
import exceptions.XmlFormatException;

import java.util.*;

public class XmlDataSetter {
    private static final int ONLY_ITEM = 0;
    private static final String RESOURCE_PACKAGE = "resources/xmlNaming";
    private static final ResourceBundle MY_RESOURCES = ResourceBundle.getBundle(RESOURCE_PACKAGE);

    private static final String NAME = MY_RESOURCES.getString("name");
    private static final String VALUE = MY_RESOURCES.getString("value");

    private static final String BACKGROUND_COLOR = MY_RESOURCES.getString("background_color");
    private static final String LINE_COLOR = MY_RESOURCES.getString("line_color");
    private static final String STARTING_IMAGE = MY_RESOURCES.getString("starting_image");
    private static final String COMMAND_LANGUAGE = MY_RESOURCES.getString("command_language");


    public VariableStorage setValueVariables(Map<String, Map<String, String>> valueVariableMap) {
        VariableStorage newValueVariableStorage = new VariableStorage();

        for(String oneVariableKey : valueVariableMap.keySet()) {
            Map<String, String> oneValueVariableMap = valueVariableMap.get(oneVariableKey);


            newValueVariableStorage.setVariable(
                    oneValueVariableMap.get(NAME),
                    Double.parseDouble(oneValueVariableMap.get(VALUE))
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

    public WorkspaceLoadPreferences setWorkspaceLoadPreferences(Map<String, Object> workspaceMap) throws XmlFormatException {
        List<Integer> backgroundColor = new ArrayList<>();
        List<Integer> lineColor = new ArrayList<>();

        Map<String, String> colorMap = new HashMap<>();
        try {
            colorMap = (Map<String, String>) workspaceMap.get(BACKGROUND_COLOR);
        }
        catch (Exception e) {
            throw new XmlFormatException(BACKGROUND_COLOR);
        }

        for(String colorKey : colorMap.keySet()){
            backgroundColor.add(Integer.parseInt(colorMap.get(colorKey)));
        }

        Map<String, String> lineColorMap = new HashMap<>();

        try {
            lineColorMap = (Map<String, String>) workspaceMap.get(LINE_COLOR);
        }
        catch(NullPointerException e) {
            throw new XmlFormatException(LINE_COLOR);
        }

        for(String colorKey : lineColorMap.keySet()){
            lineColor.add(Integer.parseInt(colorMap.get(colorKey)));
        }

        String startingImage;
        String commandLanguage;

        try {
            startingImage = (String) workspaceMap.get(STARTING_IMAGE);
        }
        catch(NullPointerException e) {
            throw new XmlFormatException(STARTING_IMAGE);
        }
        try {
            commandLanguage = (String) workspaceMap.get(COMMAND_LANGUAGE);
        }
        catch(NullPointerException e) {
            throw new XmlFormatException(COMMAND_LANGUAGE);
        }
        return new WorkspaceLoadPreferences(backgroundColor, lineColor, startingImage, commandLanguage);
    }
}
