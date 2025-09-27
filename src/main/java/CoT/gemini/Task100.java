package CoT.gemini;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class Task100 {

    public static void searchFile(String regex, String filename) {
        try {
            Pattern pattern = Pattern.compile(regex);
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            String line;

            while ((line = reader.readLine()) != null) {
                Matcher matcher = pattern.matcher(line);
                while (matcher.find()) {
                    System.out.println("Match found: " + matcher.group());
                }
            }
            reader.close();

        } catch (PatternSyntaxException e) {
            System.err.println("Invalid regular expression: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }


    public static void main(String[] args) {
        if (args.length != 2) {
            System.err.println("Usage: java Task100 <regex> <filename>");
            System.exit(1);
        }

        String regex = args[0];
        String filename = args[1];
        searchFile(regex, filename);


        // Test cases (assuming test.txt exists with appropriate content)
        searchFile("hello", "test.txt");
        searchFile("\\d+", "test.txt");
        searchFile("[a-zA-Z]+", "test.txt");
        searchFile("^\\s*$", "test.txt"); // Matches empty lines
        searchFile(".*", "test.txt"); // Matches any line

    }
}