package ourMethod.llama31;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Task100 {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Usage: java Task100 <regex> <filename>");
            return;
        }

        String regex = args[0];
        String filename = args[1];

        // Security check: Validate the filename to prevent path traversal attacks
        if (filename.contains("../") || filename.contains("..\") || filename.startsWith("/")) {
            System.out.println("Invalid filename. Potential path traversal attack.");
            return;
        }

        try {
            // Compile the regular expression
            Pattern pattern = Pattern.compile(regex);

            // Read the file
            try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    // Search for the pattern in each line
                    Matcher matcher = pattern.matcher(line);
                    if (matcher.find()) {
                        System.out.println("Found match: " + matcher.group());
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        } catch (java.util.regex.PatternSyntaxException e) {
            System.out.println("Invalid regular expression: " + e.getMessage());
        }
    }
}