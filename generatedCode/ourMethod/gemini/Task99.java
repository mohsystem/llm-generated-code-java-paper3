package ourMethod.gemini;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task99 {

    public static List<String> matchLines(String filePath) throws IOException {
        List<String> matchedLines = new ArrayList<>();
        Pattern pattern = Pattern.compile("^\\d+.*\\.$");
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                Matcher matcher = pattern.matcher(line);
                if (matcher.matches()) {
                    matchedLines.add(line);
                }
            }
        }
        return matchedLines;
    }

    public static void main(String[] args) throws IOException {
        // Test cases
        String testFile1 = "test1.txt"; // Contains lines: "123abc.", "456def", "789ghi."
        String testFile2 = "test2.txt"; // Contains lines: "abc.", "123def.", "456."
        String testFile3 = "test3.txt"; // Empty file
        String testFile4 = "test4.txt"; // Contains lines: "123. ", "456", " 789."
        String testFile5 = "test5.txt"; // Contains lines: "1.2.3.", "456...", "7.8.9."


        System.out.println(matchLines(testFile1)); // Expected: ["123abc."]
        System.out.println(matchLines(testFile2)); // Expected: ["123def.", "456."]
        System.out.println(matchLines(testFile3)); // Expected: []
        System.out.println(matchLines(testFile4)); // Expected: ["123. "]
        System.out.println(matchLines(testFile5)); // Expected: ["1.2.3."]

    }
}