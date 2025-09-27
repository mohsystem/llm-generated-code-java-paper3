package ZeroShot.codestral;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class Task100 {
    public static void searchPattern(String regex, String fileName) {
        try {
            Pattern pattern = Pattern.compile(regex);
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line;
            while ((line = reader.readLine()) != null) {
                Matcher matcher = pattern.matcher(line);
                while (matcher.find()) {
                    System.out.println("Match found: " + matcher.group(0));
                }
            }
            reader.close();
        } catch (PatternSyntaxException e) {
            System.out.println("Invalid regular expression pattern: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Usage: java Task100 <regex> <filename>");
            return;
        }
        searchPattern(args[0], args[1]);
    }
}