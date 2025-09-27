package ZeroShot.gpt4o;
import java.io.*;
import java.util.regex.*;

public class Task99 {

    public static void findLinesMatchingPattern(String filePath) {
        String regex = "^\\d.*\\.$";
        Pattern pattern = Pattern.compile(regex);

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                Matcher matcher = pattern.matcher(line);
                if (matcher.matches()) {
                    System.out.println(line);
                }
            }
        } catch (IOException e) {
            System.err.println("An error occurred while reading the file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        // 5 test cases (provide your own file paths)
        findLinesMatchingPattern("testfile1.txt");
        findLinesMatchingPattern("testfile2.txt");
        findLinesMatchingPattern("testfile3.txt");
        findLinesMatchingPattern("testfile4.txt");
        findLinesMatchingPattern("testfile5.txt");
    }
}