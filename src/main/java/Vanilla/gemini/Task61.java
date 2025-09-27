package Vanilla.gemini;
import org.w3c.dom.*;
import org.xml.sax.InputSource;

import javax.xml.parsers.*;
import java.io.*;

public class Task61 {

    public static String getRootElement(String xmlString) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            InputSource is = new InputSource(new StringReader(xmlString));
            Document doc = builder.parse(is);
            Element root = doc.getDocumentElement();
            return root.getNodeName();
        } catch (Exception e) {
            return null; 
        }
    }

    public static void main(String[] args) {
        String xml1 = "<note><to>Tove</to><from>Jani</from><heading>Reminder</heading><body>Don't forget me this weekend!</body></note>";
        String xml2 = "<book><title>The Great Gatsby</title><author>F. Scott Fitzgerald</author></book>";
        String xml3 = "<person><name>John Doe</name><age>30</age></person>";
        String xml4 = "<empty />";
        String xml5 = "<malformed><tag> </malformed>";

        System.out.println(getRootElement(xml1)); // Output: note
        System.out.println(getRootElement(xml2)); // Output: book
        System.out.println(getRootElement(xml3)); // Output: person
        System.out.println(getRootElement(xml4)); // Output: empty
        System.out.println(getRootElement(xml5)); // Output: null (or handle the exception as needed)
    }
}