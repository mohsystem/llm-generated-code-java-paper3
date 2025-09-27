package Vanilla.codestral;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Pattern;

public class Task99 {
    public static void main(String[] args) {
        try {
            findMatchingLines("filename.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void findMatchingLines(String filename) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String line;
        Pattern pattern = Pattern.compile("^[0-9].*\\.$");
        while ((line = reader.readLine()) != null) {
            if (pattern.matcher(line).matches()) {
                System.out.println(line);
            }
        }
        reader.close();
    }
}