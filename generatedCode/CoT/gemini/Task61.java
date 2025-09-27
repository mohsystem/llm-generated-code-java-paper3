package CoT.gemini;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class Task61 {

    public static String getRootElement(String xmlString) throws ParserConfigurationException, IOException, SAXException {
        // Create a DocumentBuilderFactory
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        // Prevent XXE attacks
        factory.setFeature("http://xml.org/sax/features/external-general-entities", false);
        factory.setFeature("http://xml.org/sax/features/external-parameter-entities", false);
        factory.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true);

        // Create a DocumentBuilder
        DocumentBuilder builder = factory.newDocumentBuilder();


        // Convert the string to an InputStream
        InputStream inputStream = new ByteArrayInputStream(xmlString.getBytes(StandardCharsets.UTF_8));


        // Parse the XML string
        Document doc = builder.parse(inputStream);

        // Normalize the document to handle text nodes correctly
        doc.getDocumentElement().normalize();


        // Get the root element
        Element root = doc.getDocumentElement();
        if (root != null) {
            return root.getNodeName();
        } else {
            return null;
        }
    }

    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        String xmlString1 = "<note><to>Tove</to><from>Jani</from><heading>Reminder</heading><body>Don't forget me this weekend!</body></note>";
        String xmlString2 = "<bookstore><book><title>The Great Gatsby</title><author>F. Scott Fitzgerald</author></book></bookstore>";
        String xmlString3 = "<data></data>";
        String xmlString4 = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><root><element1>Value1</element1><element2>Value2</element2></root>";
        String xmlString5 = "<invalid-xml><tag1></tag1><tag2>";

        System.out.println("Root element 1: " + getRootElement(xmlString1)); // Expected: note
        System.out.println("Root element 2: " + getRootElement(xmlString2)); // Expected: bookstore
        System.out.println("Root element 3: " + getRootElement(xmlString3)); // Expected: data
        System.out.println("Root element 4: " + getRootElement(xmlString4)); // Expected: root
        try {
            System.out.println("Root element 5: " + getRootElement(xmlString5)); // Expected: Exception
        } catch (SAXException e) {
            System.out.println("Root element 5: Invalid XML format");
        }
    }
}