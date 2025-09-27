package Vanilla.claude;

import java.util.*;

class Task61 {
    static String findRootElement(String xml) {
        xml = xml.trim();
        if (!xml.startsWith("<") || !xml.endsWith(">")) {
            return "";
        }

        int firstSpace = xml.indexOf(" ");
        int firstClose = xml.indexOf(">");
        int end = Math.min(firstSpace == -1 ? xml.length() : firstSpace, firstClose);
        
        if (end <= 1) {
            return "";
        }
        
        return xml.substring(1, end);
    }

    public static void main(String[] args) {
        String[] testCases = {
            "<root><child>Data</child></root>",
            "<note><to>John</to><from>Jane</from></note>",
            "<book category='fiction'><title>Example</title></book>",
            "<data />",
            "<invalid"
        };

        for (String test : testCases) {
            System.out.println("Input: " + test);
            System.out.println("Root element: " + findRootElement(test));
            System.out.println();
        }
    }
}
