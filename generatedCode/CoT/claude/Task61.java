package CoT.claude;

import java.util.Stack;

public class Task61 {
    public static String findXMLRoot(String xml) {
        if (xml == null || xml.trim().isEmpty()) {
            return "";
        }
        
        // Remove whitespace and comments
        xml = xml.trim().replaceAll("<!--.*?-->", "");
        
        Stack<String> tags = new Stack<>();
        String root = "";
        int i = 0;
        
        while (i < xml.length()) {
            if (xml.charAt(i) == '<') {
                if (xml.charAt(i + 1) == '/') {
                    // Closing tag
                    i += 2;
                    StringBuilder tag = new StringBuilder();
                    while (i < xml.length() && xml.charAt(i) != '>') {
                        tag.append(xml.charAt(i));
                        i++;
                    }
                    if (!tags.isEmpty() && tags.peek().equals(tag.toString())) {
                        tags.pop();
                    }
                } else {
                    // Opening tag
                    i++;
                    StringBuilder tag = new StringBuilder();
                    while (i < xml.length() && xml.charAt(i) != '>' && !Character.isWhitespace(xml.charAt(i))) {
                        tag.append(xml.charAt(i));
                        i++;
                    }
                    if (tags.isEmpty()) {
                        root = tag.toString();
                    }
                    tags.push(tag.toString());
                    while (i < xml.length() && xml.charAt(i) != '>') i++;
                }
            }
            i++;
        }
        return root;
    }

    public static void main(String[] args) {
        // Test cases
        String xml1 = "<root><child>value</child></root>";
        String xml2 = "<document><header>Title</header><body>Content</body></document>";
        String xml3 = "<book id='1'><title>XML Basics</title></book>";
        String xml4 = "<!-- comment --><data><item>1</item></data>";
        String xml5 = "<root attr='val'/>";

        System.out.println("Root 1: " + findXMLRoot(xml1));  // Expected: root
        System.out.println("Root 2: " + findXMLRoot(xml2));  // Expected: document
        System.out.println("Root 3: " + findXMLRoot(xml3));  // Expected: book
        System.out.println("Root 4: " + findXMLRoot(xml4));  // Expected: data
        System.out.println("Root 5: " + findXMLRoot(xml5));  // Expected: root
    }
}
