package ZeroShot.codestral;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task99 {
    public static void main(String[] args) {
        try {
            findMatchingLines("file.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void findMatchingLines(String filename) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String line;
        Pattern pattern = Pattern.compile("^[0-9].*\\.$");
        while ((line = reader.readLine()) != null) {
            Matcher matcher = pattern.matcher(line);
            if (matcher.matches()) {
                System.out.println(line);
            }
        }
        reader.close();
    }
}