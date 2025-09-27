package ourMethod.codestral;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import java.io.StringReader;

public class Task61 {
    public static String getRootElement(String xmlString) throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(new InputSource(new StringReader(xmlString)));
        return doc.getDocumentElement().getNodeName();
    }

    public static void main(String[] args) {
        try {
            System.out.println(getRootElement("<root><child>Content</child></root>"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}