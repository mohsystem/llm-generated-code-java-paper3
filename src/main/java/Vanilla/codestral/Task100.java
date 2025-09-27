package Vanilla.codestral;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
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
            String content = new String(Files.readAllBytes(Paths.get(fileName)));
            Pattern pattern = Pattern.compile(regexPattern);
            Matcher matcher = pattern.matcher(content);

            while (matcher.find()) {
                System.out.println("Found match: " + matcher.group());
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        } catch (PatternSyntaxException e) {
            System.out.println("Invalid regex pattern: " + e.getMessage());
        }
    }
}