package ZeroShot.openai;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;

public class Task61 {
    public static String getRootElement(String xmlContent) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            factory.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true);
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(new java.io.ByteArrayInputStream(xmlContent.getBytes()));
            return doc.getDocumentElement().getNodeName();
        } catch (Exception e) {
            return null;
        }
    }

    public static void main(String[] args) {
        System.out.println(getRootElement("<root><child/></root>")); // root
        System.out.println(getRootElement("<root></root>")); // root
        System.out.println(getRootElement("<a><b/></a>")); // a
        System.out.println(getRootElement("<parent><child1/><child2/></parent>")); // parent
        System.out.println(getRootElement("<data><item/></data>")); // data
    }
}