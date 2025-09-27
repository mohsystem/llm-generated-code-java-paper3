package ZeroShot.llama31;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.StringReader;

public class Task61 {
    public static Element parseXML(String xmlString) throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        InputSource is = new InputSource(new StringReader(xmlString));
        Document doc = builder.parse(is);
        return doc.getDocumentElement();
    }

    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        String[] testCases = {
            "<root><child>Text</child></root>",
            "<person><name>John</name><age>30</age></person>",
            "<catalog><book id='bk101'><author>John Smith</author></book></catalog>",
            "<note><to>Tove</to><from>Jani</from><heading>Reminder</heading><body>Don't forget me this weekend!</body></note>",
            "<empty/>"
        };

        for (String testCase : testCases) {
            Element root = parseXML(testCase);
            System.out.println("Root Element: " + root.getTagName());
        }
    }
}