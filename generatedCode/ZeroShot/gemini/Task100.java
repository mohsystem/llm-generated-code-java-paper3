package ZeroShot.gemini;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class Task100 {

    public static String regexSearchInFile(String regex, String fileName) {
        try {
            String fileContent = new String(Files.readAllBytes(Paths.get(fileName)));
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(fileContent);
            StringBuilder result = new StringBuilder();
            while (matcher.find()) {
                result.append(matcher.group()).append("\n");
            }
            return result.toString().trim();
        } catch (PatternSyntaxException e) {
            return "Invalid regular expression: " + e.getMessage();
        } catch (IOException e) {
            return "Error reading file: " + e.getMessage();
        }
    }
    public static void main(String[] args) {
        String result1 = regexSearchInFile("hello", "test.txt");
        System.out.println(result1);
        String result2 = regexSearchInFile("\\d+", "test.txt");
        System.out.println(result2);
        String result3 = regexSearchInFile("[a-zA-Z]+", "test.txt");
        System.out.println(result3);
        String result4 = regexSearchInFile(".*", "test.txt");
        System.out.println(result4);
        String result5 = regexSearchInFile("invalid(", "test.txt");
        System.out.println(result5);

    }

}