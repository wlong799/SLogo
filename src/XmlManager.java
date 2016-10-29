import java.io.File;

public class XmlManager {
    public static void main(String[] args) {
        XmlParser parser = new XmlParser();
        File file = new File("src/resources/sampleFormat.xml");
        try {
            System.out.println(parser.XMLparse(file));
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
