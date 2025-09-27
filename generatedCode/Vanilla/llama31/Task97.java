package Vanilla.llama31;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathFactory;
import javax.xml.xpath.XPathConstants;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import java.io.File;

public class Task97 {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Usage: java Task97 <xpath> <xmlfile>");
            return;
        }
        String xpath = args[0];
        String xmlFile = args[1];

        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(new File(xmlFile));
            XPath xPath = XPathFactory.newInstance().newXPath();
            NodeList nodeList = (NodeList) xPath.compile(xpath).evaluate(doc, XPathConstants.NODESET);
            for (int i = 0; i < nodeList.getLength(); i++) {
                System.out.println(nodeList.item(i).getTextContent());
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}