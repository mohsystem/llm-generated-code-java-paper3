package ZeroShot.claude;

import java.util.ArrayList;
import java.util.List;

class XMLNode {
    String name;
    List<XMLNode> children;
    
    XMLNode(String name) {
        this.name = name;
        this.children = new ArrayList<>();
    }
}

public class Task61 {
    private static int index = 0;
    
    public static XMLNode parseXML(String xml) {
        if (xml == null || xml.isEmpty()) {
            return null;
        }
        
        xml = xml.trim();
        index = 0;
        return parseElement(xml);
    }
    
    private static XMLNode parseElement(String xml) {
        if (index >= xml.length()) return null;
        
        // Skip whitespace
        while (index < xml.length() && Character.isWhitespace(xml.charAt(index))) {
            index++;
        }
        
        // Check for opening tag
        if (xml.charAt(index) != '<') return null;
        index++;
        
        // Get tag name
        StringBuilder tagName = new StringBuilder();
        while (index < xml.length() && xml.charAt(index) != '>') {
            tagName.append(xml.charAt(index));
            index++;
        }
        index++; // Skip '>'
        
        XMLNode node = new XMLNode(tagName.toString());
        
        // Parse children until closing tag
        while (index < xml.length()) {
            if (xml.charAt(index) == '<' && xml.charAt(index + 1) == '/') {
                // Found closing tag
                index = xml.indexOf('>', index) + 1;
                break;
            }
            XMLNode child = parseElement(xml);
            if (child != null) {
                node.children.add(child);
            } else {
                index++;
            }
        }
        
        return node;
    }

    public static void main(String[] args) {
        // Test cases
        String[] testCases = {
            "<root><child1/><child2/></root>",
            "<document><header>Title</header><body>Content</body></document>",
            "<single/>",
            "<parent><child><grandchild/></child></parent>",
            "<root></root>"
        };
        
        for (String test : testCases) {
            XMLNode root = parseXML(test);
            System.out.println("Root element: " + root.name);
            System.out.println("Number of children: " + root.children.size());
            System.out.println("---");
        }
    }
}
