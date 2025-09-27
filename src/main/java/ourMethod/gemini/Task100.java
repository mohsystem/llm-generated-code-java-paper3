package ourMethod.gemini;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class Task100 {

    public static void searchFile(String regexPattern, String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            Pattern pattern = Pattern.compile(regexPattern);
            String line;
            while ((line = reader.readLine()) != null) {
                Matcher matcher = pattern.matcher(line);
                while (matcher.find()) {
                    System.out.println("Match found: " + matcher.group());
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        } catch (PatternSyntaxException e) {
            System.err.println("Invalid regex pattern: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        if (args.length != 2) {
            System.err.println("Usage: java Task100 <regex_pattern> <file_name>");
            System.exit(1);
        }

        String regexPattern = args[0];
        String fileName = args[1];

        searchFile(regexPattern, fileName);


        // Test cases
        searchFile("hello", "test1.txt");
        searchFile("\\d+", "test2.txt");
        searchFile("^[a-zA-Z]+$", "test3.txt");
        searchFile("[aeiou]", "test4.txt");
        searchFile(".*error.*", "test5.txt");
    }
}