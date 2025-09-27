package CoT.codestral;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class Task100 {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Usage: java Task100 <regex_pattern> <file_name>");
            return;
        }

        String regexPattern = args[0];
        String fileName = args[1];

        try {
            Pattern pattern = Pattern.compile(regexPattern);
            searchFile(pattern, fileName);
        } catch (PatternSyntaxException e) {
            System.out.println("Invalid regular expression pattern: " + regexPattern);
        }
    }

    private static void searchFile(Pattern pattern, String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                Matcher matcher = pattern.matcher(line);
                if (matcher.find()) {
                    System.out.println("Match found: " + line);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + fileName);
        }
    }
}