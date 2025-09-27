package ZeroShot.codestral;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import java.io.StringReader;

public class Task61 {
    public static String getRootElement(String xml) throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true);
        Document doc = factory.newDocumentBuilder().parse(new InputSource(new StringReader(xml)));
        return doc.getDocumentElement().getNodeName();
    }

    public static void main(String[] args) throws Exception {
        String[] xmls = {
            "<root><child>Hello</child></root>",
            "<root><child1><child2>World</child2></child1></root>",
            "<root><child1 attr='val1'><child2 attr='val2'>!</child2></child1></root>",
            "<root attr='val'></root>",
            "<root>Text</root>"
        };
        for (String xml : xmls) {
            System.out.println(getRootElement(xml));
        }
    }
}