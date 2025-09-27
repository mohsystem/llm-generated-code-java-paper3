package ourMethod.gpt4o;
import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

public class Task97 {
    public static String executeXPathQuery(String xmlFileName, String xpathExpression) {
        try {
            File xmlFile = new File(xmlFileName);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            dbFactory.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true);
            dbFactory.setFeature("http://xml.org/sax/features/external-general-entities", false);
            dbFactory.setFeature("http://xml.org/sax/features/external-parameter-entities", false);
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);
            doc.getDocumentElement().normalize();

            XPathFactory xPathfactory = XPathFactory.newInstance();
            XPath xpath = xPathfactory.newXPath();
            XPathExpression expr = xpath.compile(xpathExpression);
            NodeList nl = (NodeList) expr.evaluate(doc, XPathConstants.NODESET);
            if (nl.getLength() > 0) {
                return nl.item(0).getTextContent();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(executeXPathQuery("test1.xml", "/tag[@id='1']"));
        System.out.println(executeXPathQuery("test2.xml", "/tag[@id='2']"));
        System.out.println(executeXPathQuery("test3.xml", "/tag[@id='3']"));
        System.out.println(executeXPathQuery("test4.xml", "/tag[@id='4']"));
        System.out.println(executeXPathQuery("test5.xml", "/tag[@id='5']"));
    }
}