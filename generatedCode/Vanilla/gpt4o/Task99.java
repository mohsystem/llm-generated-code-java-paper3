package Vanilla.gpt4o;
import java.io.*;
import java.util.regex.*;

public class Task99 {
    public static boolean matchLine(String line) {
        String regex = "^[0-9].*\\.$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(line);
        return matcher.find();
    }

    public static void main(String[] args) {
        String[] testCases = {
            "1. This is a test line.",
            "No number at start.",
            "2 Another line.",
            "3. Line with number at start and dot at end.",
            "No dot at end 4"
        };

        for (String testCase : testCases) {
            System.out.println(testCase + " -> " + matchLine(testCase));
        }
    }
}