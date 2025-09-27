package Vanilla.claude;

import java.io.*;
import java.util.regex.*;

public class Task99 {
    public static boolean matchLine(String line) {
        Pattern pattern = Pattern.compile("^\\\\d+.*\\\\.$");
        Matcher matcher = pattern.matcher(line);
        return matcher.matches();
    }

    public static void main(String[] args) {
        // Test cases
        String[] tests = {
            "123 abc.",
            "456 def test.",
            "abc 123.",
            "789.",
            "1 this is a test."
        };
        
        for(String test : tests) {
            System.out.println("Line: " + test);
            System.out.println("Matches: " + matchLine(test));
        }
    }
}
