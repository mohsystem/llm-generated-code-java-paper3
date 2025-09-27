package ourMethod.codestral;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task99 {
    private static final Pattern LINE_PATTERN = Pattern.compile("^\\d.*\\.$");

    public static void main(String[] args) {
        String fileName = "file.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                Matcher matcher = LINE_PATTERN.matcher(line);
                if (matcher.matches()) {
                    System.out.println(line);
                }
            }
        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
        }
    }
}