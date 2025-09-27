package Vanilla.llama31;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.InputSource;
import java.io.StringReader;

public class Task61 {
    public static String getRootElement(String xmlString) throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        InputSource is = new InputSource(new StringReader(xmlString));
        Document doc = builder.parse(is);
        Element root = doc.getDocumentElement();
        return root.getTagName();
    }

    public static void main(String[] args) throws Exception {
        String[] testCases = {
            "<library country='USA' language='English' owner='Apify'><book format='hardcover' language='English' availability_in_store='true'><title>Harry Potter and the Sorcerer's Stone</title><author>J.K. Rowling</author><genre>Fantasy</genre><publication_year>1997</publication_year><isbn>978-0439708180</isbn><price>19.99</price><payment><cod>no</cod><refund>yes</refund></payment></book></library>",
            "<catalog><book id='bk101'><author>John Smith</author><title>XML for Dummies</title><genre>Computer</genre><price>39.95</price><publish_date>2000-10-01</publish_date><description>An XML tutorial.</description></book></catalog>",
            "<note><to>Tove</to><from>Jani</from><heading>Reminder</heading><body>Don't forget me this weekend!</body></note>",
            "<person><name>John Doe</name><age>30</age><city>New York</city></person>",
            "<books><book><title>The Great Gatsby</title><author>F. Scott Fitzgerald</author></book><book><title>To Kill a Mockingbird</title><author>Harper Lee</author></book></books>"
        };

        for (String xmlString : testCases) {
            System.out.println(getRootElement(xmlString));
        }
    }
}