package ZeroShot.gemini;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Task99 {
    public static List<String> matchLines(String filePath) {
        List<String> matchingLines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            Pattern pattern = Pattern.compile("^\\d+.*\\.$");
            while ((line = reader.readLine()) != null) {
                Matcher matcher = pattern.matcher(line);
                if (matcher.matches()) {
                    matchingLines.add(line);
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
        return matchingLines;
    }

    public static void main(String[] args) {
        System.out.println(matchLines("test1.txt"));
        System.out.println(matchLines("test2.txt"));
        System.out.println(matchLines("test3.txt"));
        System.out.println(matchLines("test4.txt"));
        System.out.println(matchLines("test5.txt"));
    }
}