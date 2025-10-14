package ourMethodv2.gpt4o;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task100 {
    public static boolean searchInFile(String pattern, String fileName) {
        try {
            Pattern compiledPattern = Pattern.compile(pattern);
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line;
            while ((line = reader.readLine()) != null) {
                Matcher matcher = compiledPattern.matcher(line);
                if (matcher.find()) {
                    reader.close();
                    return true;
                }
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(searchInFile("test", "testfile.txt")); // Example test case
        System.out.println(searchInFile("hello", "file1.txt"));
        System.out.println(searchInFile("1234", "numbers.txt"));
        System.out.println(searchInFile("world", "document.txt"));
        System.out.println(searchInFile("pattern", "content.txt"));
    }
}