package Vanilla.gpt4o;
import java.io.*;

public class Task39 {
    public static void displayFileContents(String filename) {
        try {
            Process process = Runtime.getRuntime().exec("cat " + filename);
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            process.waitFor();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        displayFileContents("file1.txt");
        displayFileContents("file2.txt");
        displayFileContents("file3.txt");
        displayFileContents("file4.txt");
        displayFileContents("file5.txt");
    }
}