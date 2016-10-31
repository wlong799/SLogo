package xml;

import controller.workspace.WorkspaceLoadPreferences;
import dataStorage.DataStorageManager;

import java.io.File;
import java.util.Map;
import java.util.ResourceBundle;

public class XmlManager {
    private static final String RESOURCE_PACKAGE = "resources/xmlNaming";
    private ResourceBundle myResources = ResourceBundle.getBundle(RESOURCE_PACKAGE);

    public void saveCommandsVariables(DataStorageManager dataStorage) {
        XmlSaver saver = new XmlSaver();
        saver.saveCommandsVariables(dataStorage);
    }

    public WorkspaceLoadPreferences loadWorkspacePreferences(File givenXml) throws Exception {
        XmlParser parser = new XmlParser();
        Map<String, Object> parsedMap = parser.XmlParse(givenXml);

        Map<String, Object> workspaceMap = (Map<String, Object>) parsedMap.get(myResources.getString("saved_workspace"));

        XmlDataSetter setter = new XmlDataSetter();

        return setter.setWorkspaceLoadPreferences(workspaceMap);
    }
}
