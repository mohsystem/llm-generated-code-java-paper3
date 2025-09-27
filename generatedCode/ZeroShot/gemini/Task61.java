package ZeroShot.gemini;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

class Task61 {
    public static String getRootElement(String xmlString) throws ParserConfigurationException, IOException, SAXException {
        if (xmlString == null || xmlString.trim().isEmpty()) {
            return null;
        }

        try (InputStream is = new ByteArrayInputStream(xmlString.getBytes(StandardCharsets.UTF_8))) {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(is);
            doc.getDocumentElement().normalize();

            Element root = doc.getDocumentElement();
            if (root != null) {
                return root.getTagName();
            }
        }
        return null;

    }

    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        String xml1 = "<note><to>Tove</to><from>Jani</from><heading>Reminder</heading><body>Don't forget me this weekend!</body></note>";
        System.out.println(getRootElement(xml1)); // Output: note

        String xml2 = "<bookstore><book><title lang=\"en\">Harry Potter</title><price>29.99</price></book></bookstore>";
        System.out.println(getRootElement(xml2)); // Output: bookstore

        String xml3 = "<root><element1 /><element2></element2></root>";
        System.out.println(getRootElement(xml3)); // Output: root


        String xml4 = "";
        System.out.println(getRootElement(xml4)); // Output: null

        String xml5 = null;
        System.out.println(getRootElement(xml5)); // Output: null


    }
}