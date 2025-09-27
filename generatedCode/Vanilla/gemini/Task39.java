package Vanilla.gemini;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Task39 {
    public static void displayFileContents(String filename) throws IOException {
        ProcessBuilder pb = new ProcessBuilder("cat", filename); // Use "type" for Windows
        Process p = pb.start();
        BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
        reader.close();
    }

    public static void main(String[] args) {
        try {
            displayFileContents("test1.txt");
            displayFileContents("test2.txt");
            displayFileContents("test3.txt");
            displayFileContents("test4.txt");
            displayFileContents("test5.txt");


        } catch (IOException e) {
            System.err.println("Error displaying file contents: " + e.getMessage());
        }
    }
}