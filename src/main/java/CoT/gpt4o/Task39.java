package CoT.gpt4o;
import java.io.*;

public class Task39 {

    public static void displayFileContents(String filename) {
        ProcessBuilder processBuilder = new ProcessBuilder();
        processBuilder.command("sh", "-c", "cat " + filename);

        try {
            Process process = processBuilder.start();
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            int exitCode = process.waitFor();
            if (exitCode != 0) {
                System.err.println("Error occurred while trying to display the file.");
            }

        } catch (IOException | InterruptedException e) {
            System.err.println("Exception occurred: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        displayFileContents("example1.txt");
        displayFileContents("example2.txt");
        displayFileContents("example3.txt");
        displayFileContents("example4.txt");
        displayFileContents("example5.txt");
    }
}