package ourMethodv2.gpt4o;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;

public class Task61 {
    public static String getRootElement(String xmlContent) throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        try (ByteArrayInputStream input = new ByteArrayInputStream(xmlContent.getBytes())) {
            Document document = builder.parse(input);
            Element root = document.getDocumentElement();
            return root.getNodeName();
        }
    }
    
    public static void main(String[] args) {
        try {
            System.out.println(getRootElement("<root><child /></root>")); // Test case 1
            System.out.println(getRootElement("<a><b /></a>")); // Test case 2
            System.out.println(getRootElement("<parent><child1 /><child2 /></parent>")); // Test case 3
            System.out.println(getRootElement("<data><entry /></data>")); // Test case 4
            System.out.println(getRootElement("<html><body></body></html>")); // Test case 5
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}