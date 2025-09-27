package ZeroShot.llama31;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.bind.Element;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

public class Task97 {
    public static void main(String[] args) {
        String[] testCases = {
            "/tag[@id=1]", "test.xml", "1",
            "/tag[@id=2]", "test.xml", "2",
            "/tag[@id=3]", "test.xml", "3",
            "/tag[@id=4]", "test.xml", "4",
            "/tag[@id=5]", "test.xml", "5"
        };

        for (int i = 0; i < testCases.length; i += 3) {
            String xpath = testCases[i];
            String xmlFile = testCases[i + 1];
            String id = testCases[i + 2];

            try {
                // Execute the XPath query
                DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
                DocumentBuilder builder = factory.newDocumentBuilder();
                Document document = builder.parse(xmlFile);

                XPath xPath = XPathFactory.newInstance().newXPath();
                String xpathQuery = xpath.replace("{id}", id);
                NodeList nodeList = (NodeList) xPath.compile(xpathQuery).evaluate(document, XPathConstants.NODESET);

                for (int j = 0; j < nodeList.getLength(); j++) {
                    org.w3c.dom.Node node = nodeList.item(j);
                    if (node.getNodeType() == Node.ELEMENT_NODE) {
                        org.w3c.dom.Element element = (org.w3c.dom.Element) node;
                        System.out.println("Result: " + element.getTextContent());
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}