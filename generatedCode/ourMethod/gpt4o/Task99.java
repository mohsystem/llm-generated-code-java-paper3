package ourMethod.openai;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task99 {
    public static ArrayList<String> findMatchingLines(String filePath) {
        ArrayList<String> matchingLines = new ArrayList<>();
        Pattern pattern = Pattern.compile("^\\d.*\\.$");

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                Matcher matcher = pattern.matcher(line);
                if (matcher.find()) {
                    matchingLines.add(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return matchingLines;
    }

    public static void main(String[] args) {
        String testFilePath = "test.txt";
        // Assuming test.txt exists and is accessible.

        ArrayList<String> results = findMatchingLines(testFilePath);
        for (String line : results) {
            System.out.println(line);
        }
    }
}