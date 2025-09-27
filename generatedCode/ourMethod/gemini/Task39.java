package ourMethod.gemini;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Task39 {

    public static String displayFileContents(String filename) throws IOException {
        // Use ProcessBuilder for better security and control
        ProcessBuilder pb = new ProcessBuilder("cat", filename);  // Use "type" for Windows or "cat" for Linux/macOS
        Process p = pb.start();

        BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
        StringBuilder output = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            output.append(line).append("\n");
        }

        int exitCode = p.waitFor();
        if (exitCode != 0) {
            // Handle errors, such as file not found
            BufferedReader errorReader = new BufferedReader(new InputStreamReader(p.getErrorStream()));
            String errorLine;
            while ((errorLine = errorReader.readLine()) != null) {
                System.err.println(errorLine);
            }
            return "Error: " + exitCode; // Indicate an error
        }
        return output.toString();
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // Test cases
            System.out.println(displayFileContents("test1.txt"));
            System.out.println(displayFileContents("test2.txt"));
            System.out.println(displayFileContents("test3.txt"));  // Potentially a file that doesn't exist
            System.out.println(displayFileContents("test4.txt"));
            System.out.println(displayFileContents("test5.txt"));


        } catch (IOException e) {
            System.err.println("Error executing command: " + e.getMessage());
        } catch (InterruptedException e) {
            System.err.println("Interrupted: " + e.getMessage());
        } finally {
            scanner.close();
        }

    }
}