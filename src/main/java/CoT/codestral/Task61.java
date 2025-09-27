package CoT.codestral;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import java.io.StringReader;
import javax.xml.parsers.DocumentBuilder;
import org.xml.sax.InputSource;

public class Task61 {
    public static Element getRootElement(String xmlString) throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(new InputSource(new StringReader(xmlString)));
        return doc.getDocumentElement();
    }

    public static void main(String[] args) {
        try {
            String xmlString = "<root><child>Text</child></root>";
            Element rootElement = getRootElement(xmlString);
            System.out.println("Root element: " + rootElement.getNodeName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}