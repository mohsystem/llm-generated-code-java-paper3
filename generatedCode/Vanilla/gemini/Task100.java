package Vanilla.gemini;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task100 {

    public static void findMatches(String regex, String fileName) throws IOException {
        String content = new String(Files.readAllBytes(Paths.get(fileName)));
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(content);

        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }

    public static void main(String[] args) throws IOException {
        findMatches(args[0], args[1]);


        // Test cases (assuming a file "test.txt" exists with appropriate content):
        findMatches("hello", "test.txt");
        findMatches("\\d+", "test.txt");
        findMatches("[A-Z]+", "test.txt");
        findMatches("^[a-z]+", "test.txt"); // matches the beginning of lines only
        findMatches("\\b\\w+\\b", "test.txt"); // matches whole words only
    }
}