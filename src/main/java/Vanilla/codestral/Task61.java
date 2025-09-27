package Vanilla.codestral;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import java.io.StringReader;

public class Task61 {
    public static String parseXml(String xml) throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        InputSource is = new InputSource(new StringReader(xml));
        Document doc = builder.parse(is);
        return doc.getDocumentElement().getNodeName();
    }

    public static void main(String[] args) {
        String[] testCases = {
            "<root><element1>data</element1></root>",
            "<main><sub1>data1</sub1><sub2>data2</sub2></main>",
            "<parent><child1>child1 data</child1><child2>child2 data</child2></parent>",
            "<top><middle><bottom>bottom data</bottom></middle></top>",
            "<first><second><third><fourth>fourth data</fourth></third></second></first>"
        };

        for (String testCase : testCases) {
            try {
                System.out.println("Root element of XML document is: " + parseXml(testCase));
            } catch (Exception e) {
                System.out.println("Error parsing XML: " + e.getMessage());
            }
        }
    }
}