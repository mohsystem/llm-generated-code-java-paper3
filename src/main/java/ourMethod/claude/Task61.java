package ourMethod.claude;

public class Task61 {
    public static String getRootElement(String xmlString) {
        if (xmlString == null || xmlString.trim().isEmpty()) {
            return "";
        }
        
        // Remove whitespace and comments
        xmlString = xmlString.trim();
        xmlString = xmlString.replaceAll("<!--.*?-->", "");
        
        // Check for XML declaration and skip it
        int startIdx = xmlString.startsWith("<?xml") ? xmlString.indexOf("?>") + 2 : 0;
        
        // Find first < after XML declaration
        while (startIdx < xmlString.length() && xmlString.charAt(startIdx) != '<') {
            startIdx++;
        }
        
        if (startIdx >= xmlString.length()) {
            return "";
        }
        
        // Find end of root tag
        int endIdx = xmlString.indexOf('>', startIdx);
        if (endIdx == -1) {
            return "";
        }
        
        // Extract root element name
        String tag = xmlString.substring(startIdx + 1, endIdx);
        // Remove any attributes
        int spaceIdx = tag.indexOf(' ');
        if (spaceIdx != -1) {
            tag = tag.substring(0, spaceIdx);
        }
        
        return tag;
    }

    public static void main(String[] args) {
        // Test cases
        String[] tests = {
            "<?xml version=\"1.0\"?><root><child>Test</child></root>",
            "<simple>content</simple>",
            "<!-- comment --><root attr=\"value\">content</root>",
            "<?xml version=\"1.0\" encoding=\"UTF-8\"?><root/>",
            "<root xmlns=\"http://example.com\">test</root>"
        };
        
        for (String test : tests) {
            System.out.println("Input: " + test);
            System.out.println("Root: " + getRootElement(test));
            System.out.println();
        }
    }
}
