package ourMethodv2.gpt4o;
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
    public static String executeXPath(String xmlFile, String xpathExpr) {
        try {
            File file = new File(xmlFile);
            if (!file.exists()) {
                return "File not found.";
            }

            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            dbFactory.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true);  // Mitigate XXE
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(file);

            XPathFactory xPathFactory = XPathFactory.newInstance();
            XPath xpath = xPathFactory.newXPath();
            XPathExpression expr = xpath.compile(xpathExpr);

            NodeList nl = (NodeList) expr.evaluate(doc, XPathConstants.NODESET);
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < nl.getLength(); i++) {
                result.append(nl.item(i).getTextContent()).append("\n");
            }
            return result.toString().trim();
        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }
    }

    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Usage: java Task97 <xpath> <xmlFile>");
            return;
        }

        String xpath = args[0];
        String xmlFile = args[1];
        System.out.println(executeXPath(xmlFile, xpath));
    }
}