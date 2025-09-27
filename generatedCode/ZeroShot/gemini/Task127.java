package ZeroShot.gemini;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

class Task127 {
    public static void copyFileToTemp(String sourceFilePath) {
        try {
            File sourceFile = new File(sourceFilePath);
            if (!sourceFile.exists()) {
                throw new FileNotFoundException("Source file not found: " + sourceFilePath);
            }

            Path tempFile = Files.createTempFile("temp_", ".tmp");
            Files.copy(sourceFile.toPath(), tempFile);

            System.out.println("File copied successfully to: " + tempFile);

        } catch (FileNotFoundException e) {
            System.err.println("Error: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("An I/O error occurred: " + e.getMessage());
        } catch (SecurityException e) {
            System.err.println("A security exception occurred: " + e.getMessage());
        }
    }


    public static void main(String[] args) {
        copyFileToTemp("test1.txt");
        copyFileToTemp("nonexistent_file.txt");
        copyFileToTemp("test2.txt");
        copyFileToTemp(""); 
        copyFileToTemp("test3.txt");


        try {
            // Create some test files
            new File("test1.txt").createNewFile();
            new File("test2.txt").createNewFile();
            new File("test3.txt").createNewFile();


        } catch (IOException e) {
            System.err.println("Error creating test files: " + e.getMessage());
        }


    }
}