package CoT.gpt4o;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Task99 {
    public static boolean matchLine(String line) {
        Pattern pattern = Pattern.compile("^\\d.*\\.$");
        Matcher matcher = pattern.matcher(line);
        return matcher.find();
    }

    public static void readFileAndMatch(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (matchLine(line)) {
                    System.out.println("Match: " + line);
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        // Test cases
        readFileAndMatch("test1.txt");
        readFileAndMatch("test2.txt");
        readFileAndMatch("test3.txt");
        readFileAndMatch("test4.txt");
        readFileAndMatch("test5.txt");
    }
}