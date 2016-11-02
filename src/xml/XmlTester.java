//package xml;
//
//import dataStorage.DataStorageManager;
//import dataStorage.TurtleStorage;
//import java.io.File;
//import java.util.Map;
//import java.util.ResourceBundle;
//
//public class XmlTester {
//    private static final String LANGUAGE = "English";
//
//    private static final String RESOURCE_PACKAGE = "resources/xmlNaming";
//    private ResourceBundle myResources;
//
//    public static void main (String[] args) {
//        ResourceBundle myResources = ResourceBundle.getBundle(RESOURCE_PACKAGE);
//
//        XmlParser parser = new XmlParser();
//        File file = new File("src/resources/sampleFormat.xml");
//        try {
//            Map<String, Object> parsedMap =
//                    (Map<String, Object>) parser.XMLparse(file).get("saved_workspace");
//            ////System.out.println(parsedMap);
//
//            /* Now set the parsed Data */
//            XmlDataSetter dataSetter = new XmlDataSetter(LANGUAGE);
//
//            DataStorageManager fakeStorageManager = new DataStorageManager();
//
//            Map<String, Map<String, String>> colorStorage =
//                    (Map<String, Map<String, String>>) parsedMap
//                            .get(myResources.getString("color_storage"));
//            fakeStorageManager.setColorStorage(dataSetter.setColors(colorStorage));
//
//            Map<String, Map<String, String>> commandStorage =
//                    (Map<String, Map<String, String>>) parsedMap
//                            .get(myResources.getString("function_storage"));
//            fakeStorageManager
//                    .setCommandStorage(dataSetter.setCommandVariables(commandStorage));
//
//            Map<String, Map<String, String>> variableStorage =
//                    (Map<String, Map<String, String>>) parsedMap
//                            .get(myResources.getString("variable_storage"));
//            fakeStorageManager.setVariableStorage(dataSetter.setValueVariables(variableStorage));
//
//            Map<String, Map<String, String>> turtleStorage =
//                    (Map<String, Map<String, String>>) parsedMap
//                            .get(myResources.getString("turtle_storage"));
//            TurtleStorage fakeTurtleStorage = dataSetter.setTurtles(turtleStorage);
//
//            XmlSaver fakeSaver = new XmlSaver(LANGUAGE);
//
////            fakeSaver.saveAsXml(fakeStorageManager, fakeTurtleStorage);
//        }
//        catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//}
