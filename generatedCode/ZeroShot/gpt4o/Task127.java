package ZeroShot.openai;
import java.io.*;

public class Task127 {
    public static void handleFileOperation(String inputFilePath, String outputFilePath) {
        BufferedReader reader = null;
        BufferedWriter writer = null;

        try {
            reader = new BufferedReader(new FileReader(inputFilePath));
            writer = new BufferedWriter(new FileWriter(outputFilePath));

            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("File operation error: " + e.getMessage());
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
                if (writer != null) {
                    writer.close();
                }
            } catch (IOException e) {
                System.err.println("Error closing files: " + e.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        // Test cases
        handleFileOperation("test1.txt", "output1.txt");
        handleFileOperation("test2.txt", "output2.txt");
        handleFileOperation("nonexistent.txt", "output3.txt");
        handleFileOperation("test4.txt", "output4.txt");
        handleFileOperation("test5.txt", "output5.txt");
    }
}