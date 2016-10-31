import java.io.File;
import java.util.Map;
import java.util.ResourceBundle;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import dataStorage.CommandStorage;
import dataStorage.DataStorageManager;
import dataStorage.Turtle;
import dataStorage.TurtleStorage;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class XmlSaver {

    private static final String RESOURCE_PACKAGE = "resources/xmlNaming";
    private ResourceBundle myResources;

    public XmlSaver(String language) {
        myResources = ResourceBundle.getBundle(RESOURCE_PACKAGE + language);
    }

    private Element createElementWithData(String nodeName, String information, Document doc) {
        Element element = doc.createElement(nodeName);
        element.appendChild(doc.createTextNode(information));

        return element;
    }

    public void saveAsXml(DataStorageManager dataStorage, TurtleStorage turtles) {

        try {

            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

            // root element
            Document doc = docBuilder.newDocument();
            Element rootElement = doc.createElement(myResources.getString("saved_workspace"));
            doc.appendChild(rootElement);

            // turtle_storage
            Element turtleStorage = doc.createElement(myResources.getString("turtle_storage"));
            rootElement.appendChild(turtleStorage);

            int turtleNum = 1;

            for(int turtleID : turtles.getActiveTurtleIDs()) {
                Element turtleElement = doc.createElement(myResources.getString("turtle_") + Integer.toString(turtleNum));

                Turtle oneTurtle = turtles.getTurtle(turtleID);

                turtleElement.appendChild(createElementWithData
                        (myResources.getString("id"), Integer.toString(turtleID), doc));

                turtleElement.appendChild(createElementWithData
                        (myResources.getString("x"), Double.toString(oneTurtle.getPosition().getX()), doc));

                turtleElement.appendChild(createElementWithData
                        (myResources.getString("y"), Double.toString(oneTurtle.getPosition().getY()), doc));

                turtleElement.appendChild(createElementWithData
                        (myResources.getString("heading"), Double.toString(oneTurtle.getHeading()), doc));

                turtleElement.appendChild(createElementWithData
                        (myResources.getString("pen_down"), Boolean.toString(oneTurtle.getPenDownStatus()), doc));

                turtleElement.appendChild(createElementWithData
                        (myResources.getString("pen_color"), Double.toString(oneTurtle.getPenColor()), doc));

                turtleElement.appendChild(createElementWithData
                        (myResources.getString("pen_size"), Double.toString(oneTurtle.getPenSize()), doc));

                turtleElement.appendChild(createElementWithData
                        (myResources.getString("visible"), Boolean.toString(oneTurtle.getVisibility()), doc));

                turtleElement.appendChild(createElementWithData
                        (myResources.getString("shape"), Double.toString(oneTurtle.getShape()), doc));

                turtleStorage.appendChild(turtleElement);

                turtleNum++;
            }


            // color_storage
            Element colorStorage = doc.createElement(myResources.getString("color_storage"));
            rootElement.appendChild(colorStorage);

            int colorNum = 1;

            Map<Integer, Map<String, Double>> colorMap = dataStorage.getColorMap();

            for(int colorIndex : colorMap.keySet()) {
                Element colorElement = doc.createElement(myResources.getString("color_") + Integer.toString(colorNum));

                colorElement.appendChild(createElementWithData
                        (myResources.getString("color_index"), Integer.toString(colorIndex), doc));

                colorElement.appendChild(createElementWithData
                        (myResources.getString("color_red"), Double.toString(colorMap.get(colorIndex).get(myResources.getString("color_red"))), doc));

                colorElement.appendChild(createElementWithData
                        (myResources.getString("color_green"), Double.toString(colorMap.get(colorIndex).get(myResources.getString("color_green"))), doc));

                colorElement.appendChild(createElementWithData
                        (myResources.getString("color_blue"), Double.toString(colorMap.get(colorIndex).get(myResources.getString("color_blue"))), doc));

                colorStorage.appendChild(colorElement);
                colorNum++;
            }

            // value variable
            Element variableStorage = doc.createElement(myResources.getString("variable_storage"));
            rootElement.appendChild(variableStorage);

            int variableNum = 1;

            Map<String, Double> variableMap = dataStorage.getValueVariableMap();

            for(String variableName : variableMap.keySet()) {
                Element variableElement = doc.createElement(myResources.getString("variable_") + Integer.toString(variableNum));

                variableElement.appendChild(createElementWithData
                        (myResources.getString("variable_name"), variableName, doc));

                variableElement.appendChild(createElementWithData
                        (myResources.getString("variable_value"), Double.toString(variableMap.get(variableName)), doc));

                variableStorage.appendChild(variableElement);

                variableNum++;
            }

            // command variable
            Element functionStorage = doc.createElement(myResources.getString("function_storage"));
            rootElement.appendChild(functionStorage);

            int functionNum = 1;

            CommandStorage commandStorage = dataStorage.getCommandStorage();

            Map<String, String> functionMap = commandStorage.getCommandMap();

            for(String functionName : functionMap.keySet()) {
                Element functionElement = doc.createElement(myResources.getString("function_") + Integer.toString(functionNum));

                functionElement.appendChild(createElementWithData
                        (myResources.getString("function_name"), functionName, doc));

                StringBuilder parameters = new StringBuilder();

                for(String oneParameter : commandStorage.getCommandParams(functionName)) {
                    parameters.append(oneParameter);
                    parameters.append(' ');
                }

                functionElement.appendChild(createElementWithData
                        (myResources.getString("function_parameters"), parameters.toString().trim(), doc));

                functionElement.appendChild(createElementWithData
                        (myResources.getString("function_body"), functionMap.get(functionName), doc));

                functionStorage.appendChild(functionElement);
                functionNum++;
            }


            // write the content into xml file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("savedState.xml"));

            // Output to console for testing
            // StreamResult result = new StreamResult(System.out);

            transformer.transform(source, result);

            System.out.println("File saved!");

            // TODO: print to the front end that can't load the file properly
        } catch (ParserConfigurationException pce) {
            pce.printStackTrace();
        } catch (TransformerException tfe) {
            tfe.printStackTrace();
        }
    }
}