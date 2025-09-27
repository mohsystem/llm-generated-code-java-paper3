package ZeroShot.codestral;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Task39 {
    public static void displayFileContents(String filename) {
        try {
            Process process = Runtime.getRuntime().exec("cat " + filename);
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        displayFileContents("test.txt");
        displayFileContents("nonexistent.txt");
        displayFileContents("/etc/passwd");
        displayFileContents("C:\\Windows\\System32\\drivers\\etc\\hosts");
        displayFileContents("../../../../../etc/passwd");
    }
}