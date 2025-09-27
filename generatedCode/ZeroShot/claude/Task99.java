package ZeroShot.claude;

import java.io.*;
import java.util.regex.*;

public class Task99 {
    public static boolean matchLine(String line) {
        if (line == null) return false;
        Pattern pattern = Pattern.compile("^\\\\d+.*\\\\.$");
        return pattern.matcher(line).matches();
    }

    public static void main(String[] args) {
        // Test cases
        String[] testLines = {
            "123 test line.",
            "456 another test.",
            "Not starting with number.",
            "789 no dot",
            "0 simple line."
        };
        
        for(String line : testLines) {
            System.out.println("Line: " + line);
            System.out.println("Matches: " + matchLine(line));
        }
    }
}
