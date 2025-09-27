package ourMethod.gpt4o;
import java.io.*;
import java.nio.file.*;
import java.util.regex.*;

public class Task100 {
    public static boolean searchPatternInFile(String pattern, String fileName) {
        Pattern compiledPattern;
        Matcher matcher;
        try {
            compiledPattern = Pattern.compile(pattern);
        } catch (PatternSyntaxException e) {
            System.err.println("Invalid regular expression pattern.");
            return false;
        }

        try (BufferedReader reader = Files.newBufferedReader(Paths.get(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                matcher = compiledPattern.matcher(line);
                if (matcher.find()) {
                    System.out.println("Pattern found: " + matcher.group());
                    return true;
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading the file.");
            return false;
        }
        System.out.println("Pattern not found.");
        return false;
    }

    public static void main(String[] args) {
        if (args.length != 2) {
            System.err.println("Usage: java Task100 <regex-pattern> <file-name>");
            return;
        }
        
        String pattern = args[0];
        String fileName = args[1];
        
        // Execute test cases
        searchPatternInFile(pattern, fileName);
    }
}