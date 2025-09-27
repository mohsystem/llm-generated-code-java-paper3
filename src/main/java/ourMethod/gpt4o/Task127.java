package ourMethod.gpt4o;
import java.io.*;
import java.nio.file.*;

public class Task127 {
    public static void main(String[] args) {
        testCases();
    }

    public static void testCases() {
        // Assuming the files exist for testing
        System.out.println(readAndWriteFile("input1.txt", "temp1.txt"));
        System.out.println(readAndWriteFile("input2.txt", "temp2.txt"));
        System.out.println(readAndWriteFile("input3.txt", "temp3.txt"));
        System.out.println(readAndWriteFile("input4.txt", "temp4.txt"));
        System.out.println(readAndWriteFile("input5.txt", "temp5.txt"));
    }

    public static String readAndWriteFile(String inputFile, String tempFile) {
        Path inputPath = Paths.get(inputFile);
        Path tempPath = Paths.get(tempFile);
        try (BufferedReader reader = Files.newBufferedReader(inputPath);
             BufferedWriter writer = Files.newBufferedWriter(tempPath)) {
            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line);
                writer.newLine();
            }
            return "File processed successfully.";
        } catch (IOException e) {
            return "An error occurred: " + e.getMessage();
        }
    }
}