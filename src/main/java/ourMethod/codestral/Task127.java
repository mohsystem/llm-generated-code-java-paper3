package ourMethod.codestral;
import java.io.*;
import java.nio.file.*;

public class Task127 {
    public static void main(String[] args) {
        test("input.txt");
    }

    public static void test(String filePath) {
        Path tempFile = null;
        try {
            Path source = Paths.get(filePath);
            tempFile = Files.createTempFile("temp", ".tmp");
            Files.copy(source, tempFile, StandardCopyOption.COPY_ATTRIBUTES);
            System.out.println("File copied to: " + tempFile);
        } catch (InvalidPathException | UnsupportedOperationException e) {
            System.out.println("Invalid path: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("I/O error: " + e.getMessage());
        } finally {
            if (tempFile != null) {
                try {
                    Files.deleteIfExists(tempFile);
                } catch (IOException e) {
                    System.out.println("Failed to delete temp file: " + e.getMessage());
                }
            }
        }
    }
}