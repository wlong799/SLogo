import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


/**
 * Handles parsing XML files by returning the root elements.
 *
 */
public class XmlParser_NEW {
    public static void parseXML(Node node, Node parent)
    {
        if (node.hasChildNodes())
        {
            System.out.println(node.getNodeName());
            NodeList childrens = node.getChildNodes();
            for (int i = 0; i < childrens.getLength(); i++)
            {
                parseXML(childrens.item(i), node);
            }//for
        }//fi:root_childrens
        else {
            String nodeValue = node.getNodeValue().trim();
            if (nodeValue.length() > 0){
                System.out.println(parent.getNodeName() + "::" + nodeValue);
            }

        }
    }
}
