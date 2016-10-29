import java.util.*;
import javax.xml.parsers.*;
import java.io.File;
import java.io.IOException;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

public class XmlParser {

    /**
     * Builds a map of the XML file to access all given rules
     * @param file
     * @return map of given rules for each game
     * @throws SAXException
     * @throws IOException
     */
    public Map<String, Object> XMLparse(File file) throws SAXException, IOException {
        DocumentBuilderFactory dbFactory =
                DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder;
        try {
            dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(file);
            doc.getDocumentElement().normalize();
            Node root = doc.getDocumentElement();
            HashMap<String, Object> rules = new HashMap<String, Object>();

            rules.put(root.getNodeName(), childMapper(root));
            return rules;

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
            return null;
        }
    }

    private Object childMapper(Node current) {
        if (current.getNodeType() == Node.ELEMENT_NODE) {
            return current.getTextContent().trim();
        }

        HashMap<String, Object> childMap = new HashMap<String, Object>();
        NodeList nList = current.getChildNodes();

        for(int i = 0; i < nList.getLength(); i++) {
            Node oneChild = nList.item(i);
            childMap.put(oneChild.getNodeName(), childMapper(oneChild));
        }
        return childMap;
    }
}