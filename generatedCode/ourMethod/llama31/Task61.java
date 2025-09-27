package ourMethod.llama31;
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
    public static Element parseXml(String xmlString) throws ParserConfigurationException, SAXException, IOException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        InputSource is = new InputSource(new StringReader(xmlString));
        Document doc = builder.parse(is);
        return doc.getDocumentElement();
    }

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        String xmlString = "<root><child>text</child></root>";
        Element root = parseXml(xmlString);
        System.out.println("Root Element: " + root.getTagName());
    }
}