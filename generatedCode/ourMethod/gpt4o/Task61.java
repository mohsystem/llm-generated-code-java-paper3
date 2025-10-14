package ourMethod.openai;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class Task61 {
    public static String getRootElement(String xmlString) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            factory.setExpandEntityReferences(false); // Prevent XXE
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new java.io.ByteArrayInputStream(xmlString.getBytes("UTF-8")));
            Element root = document.getDocumentElement();
            return root.getNodeName();
        } catch (Exception e) {
            return null;
        }
    }

    public static void main(String[] args) {
        System.out.println(getRootElement("<root><child /></root>")); // Test case 1
        System.out.println(getRootElement("<a><b></b></a>")); // Test case 2
        System.out.println(getRootElement("<library><book /></library>")); // Test case 3
        System.out.println(getRootElement("<data></data>")); // Test case 4
        System.out.println(getRootElement("<info><item></item></info>")); // Test case 5
    }
}