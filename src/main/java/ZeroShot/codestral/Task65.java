package ZeroShot.codestral;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Task65 {
    public static String readFile(String filename) {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line);
                sb.append("\n");
            }
        } catch (IOException e) {
            return "Error: " + e.getMessage();
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(readFile("test.txt"));
        System.out.println(readFile("nonexistent.txt"));
        System.out.println(readFile(""));
        System.out.println(readFile("inaccessible.txt"));
        System.out.println(readFile("directory/"));
    }
}