package ZeroShot.llama31;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Task100 {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Usage: java Task100 <regex_pattern> <file_name>");
            return;
        }

        String regexPattern = args[0];
        String fileName = args[1];

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            Pattern pattern = Pattern.compile(regexPattern);
            String line;
            int lineNumber = 1;
            while ((line = reader.readLine()) != null) {
                Matcher matcher = pattern.matcher(line);
                if (matcher.find()) {
                    System.out.println("Found match at line " + lineNumber + ": " + line);
                }
                lineNumber++;
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    public static void searchFile(String regexPattern, String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            Pattern pattern = Pattern.compile(regexPattern);
            String line;
            int lineNumber = 1;
            while ((line = reader.readLine()) != null) {
                Matcher matcher = pattern.matcher(line);
                if (matcher.find()) {
                    System.out.println("Found match at line " + lineNumber + ": " + line);
                }
                lineNumber++;
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    public static void mainTest() {
        String[] testCases = {
            new String[] {"hello", "test.txt"},
            new String[] {"world", "test.txt"},
            new String[] {"foo", "nonexistent.txt"},
            new String[] {"bar", "test.txt"},
            new String[] {"baz", "test.txt"}
        };

        for (String[] testCase : testCases) {
            searchFile(testCase[0], testCase[1]);
        }
    }

    public static void main(String[] args) {
        mainTest();
    }
}