package xml;

import controller.workspace.WorkspaceLoadPreferences;
import dataStorage.*;
import exceptions.XmlFormatException;
import java.util.*;


public class XmlDataSetter implements IXmlStrings{

    public VariableStorage setValueVariables(Map<String, Map<String, String>> valueVariableMap) throws XmlFormatException{
        VariableStorage newValueVariableStorage = new VariableStorage();

        for(String oneVariableKey : valueVariableMap.keySet()) {
            Map<String, String> oneValueVariableMap = valueVariableMap.get(oneVariableKey);
            String name;
            try {
                name = oneValueVariableMap.get(VARIABLE_NAME);
            }
            catch (NullPointerException e) {
                throw new XmlFormatException(VARIABLE_NAME);
            }

            String value;

            try {
                value = oneValueVariableMap.get(VARIABLE_VALUE);
            }
            catch(NullPointerException e) {
                throw new XmlFormatException(VARIABLE_VALUE);
            }

            newValueVariableStorage.setVariable(
                    name,
                    Double.parseDouble(value)
            );
        }

        return newValueVariableStorage;
    }

    public CommandStorage setCommandVariables(Map<String, Map<String, String>> commandVariableMap) throws XmlFormatException {
        CommandStorage newCommandVariableStorage = new CommandStorage();

        for(String oneVariableKey : commandVariableMap.keySet()) {
            Map<String, String> oneCommandVariableMap = commandVariableMap.get(oneVariableKey);

            List<String> parameterList = Arrays.asList(oneCommandVariableMap.get(FUNCTION_PARAMETERS).split(SPACE));

            String functionName;
            try{
                functionName = oneCommandVariableMap.get(FUNCTION_NAME);
            }
            catch(NullPointerException e) {
                throw new XmlFormatException(FUNCTION_NAME);
            }

            String functionBody;
            try{
                functionBody = oneCommandVariableMap.get(FUNCTION_BODY);
            }
            catch(NullPointerException e) {
                throw new XmlFormatException(FUNCTION_BODY);
            }

            newCommandVariableStorage.setCommand(
                    functionName,
                    parameterList,
                    functionBody
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
        catch(Exception e) {
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
