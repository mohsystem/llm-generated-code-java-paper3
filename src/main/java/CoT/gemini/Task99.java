package CoT.gemini;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.ArrayList;
import java.util.List;

public class Task99 {

    public static List<String> matchLines(String filePath) {
        List<String> matchingLines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            Pattern pattern = Pattern.compile("^\\d+.*\\.$"); // Regex: Starts with digit(s), ends with a dot
            while ((line = reader.readLine()) != null) {
                Matcher matcher = pattern.matcher(line);
                if (matcher.matches()) {
                    matchingLines.add(line);
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
        return matchingLines;
    }

    public static void main(String[] args) {
        List<String> test1 = matchLines("test1.txt"); // File with "123abc.", "456def", "789."
        System.out.println("Test 1: " + test1);

        List<String> test2 = matchLines("test2.txt"); // File with "abc.", "123.", "456def."
        System.out.println("Test 2: " + test2);

        List<String> test3 = matchLines("test3.txt"); // File with "1abc.", "2def.", "3ghi."
        System.out.println("Test 3: " + test3);
                
        List<String> test4 = matchLines("test4.txt"); // File doesn't exist
        System.out.println("Test 4: " + test4);

        List<String> test5 = matchLines("test5.txt"); // Empty file
        System.out.println("Test 5: " + test5);
    }
}