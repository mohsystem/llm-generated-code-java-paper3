package CoT.gemini;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Task39 {

    public static void displayFileContents(String filename) throws IOException {
        String[] command = {"cat", filename}; // Use a more secure command if available for your OS

        ProcessBuilder pb = new ProcessBuilder(command);
        Process process = pb.start();

        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }

        int exitCode = process.waitFor();
        if (exitCode != 0) {
            System.err.println("Error displaying file contents. Exit code: " + exitCode);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Enter filename: ");
            String filename = scanner.nextLine();
            displayFileContents(filename);

             // Test cases
            displayFileContents("test1.txt");
            displayFileContents("test2.txt");
            displayFileContents("test3.txt");
            displayFileContents("test4.txt");
            displayFileContents("test5.txt");


        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}