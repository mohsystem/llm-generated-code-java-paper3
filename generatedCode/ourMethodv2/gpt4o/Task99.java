package ourMethodv2.gpt4o;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Task99 {
    public static void processFile(String fileName) {
        String regex = "^[0-9].*\\.$";
        Pattern pattern = Pattern.compile(regex);
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                Matcher matcher = pattern.matcher(line);
                if (matcher.matches()) {
                    System.out.println(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        // Add the path to your test files here
        processFile("test1.txt");
        processFile("test2.txt");
        processFile("test3.txt");
        processFile("test4.txt");
        processFile("test5.txt");
    }
}