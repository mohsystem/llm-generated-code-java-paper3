package ourMethod.gemini;
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

    public static Element getRootElement(String xmlString) throws ParserConfigurationException, IOException, SAXException {
        if (xmlString == null || xmlString.trim().isEmpty()) {
            return null;
        }

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        // Security measure: prevent XXE attacks
        factory.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true);
        factory.setFeature("http://xml.org/sax/features/external-general-entities", false);
        factory.setFeature("http://xml.org/sax/features/external-parameter-entities", false);
        factory.setXIncludeAware(false);
        factory.setExpandEntityReferences(false);

        DocumentBuilder builder = factory.newDocumentBuilder();

        try (InputStream inputStream = new ByteArrayInputStream(xmlString.getBytes(StandardCharsets.UTF_8))) {
            Document doc = builder.parse(inputStream);
            return doc.getDocumentElement();
        }

    }


    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        String[] testCases = {
                "<root><element1>value1</element1><element2>value2</element2></root>",
                "<note><to>Tove</to><from>Jani</from><heading>Reminder</heading><body>Don't forget me this weekend!</body></note>",
                "<bookstore><book><title lang=\"en\">Harry Potter</title><price>29.99</price></book></bookstore>",
                "<!-- This is a comment --><root/>",
                ""
        };
        for (String testCase : testCases) {
            Element root = getRootElement(testCase);
            if (root != null) {
                System.out.println("Root element: " + root.getTagName());
            } else {
                System.out.println("Root element not found.");
            }

        }
    }

}