package CoT.gpt4o;
import java.io.*;
import java.nio.file.*;

public class Task127 {

    public static void copyFile(String sourcePath, String destPath) {
        Path source = Paths.get(sourcePath);
        Path destination = Paths.get(destPath);

        try {
            Files.copy(source, destination, StandardCopyOption.REPLACE_EXISTING);
        } catch (NoSuchFileException e) {
            System.err.println("File not found: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("I/O Error: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        copyFile("path/to/source/file1.txt", "path/to/destination/file1.txt");
        copyFile("path/to/source/file2.txt", "path/to/destination/file2.txt");
        copyFile("path/to/source/file3.txt", "path/to/destination/file3.txt");
        copyFile("path/to/source/file4.txt", "path/to/destination/file4.txt");
        copyFile("path/to/source/file5.txt", "path/to/destination/file5.txt");
    }
}