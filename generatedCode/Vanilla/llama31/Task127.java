package Vanilla.llama31;
import java.io.*;
import java.nio.file.*;

public class Task127 {
    public static void main(String[] args) {
        String[] testFiles = {"existing_file.txt", "nonexistent_file.txt", "another_existing_file.txt", "yet_another_nonexistent_file.txt", "file_with_permissions_issue.txt"};

        for (String file : testFiles) {
            try {
                readAndWriteToFile(file);
            } catch (Exception e) {
                System.err.println("Error processing file " + file + ": " + e.getMessage());
            }
        }
    }

    public static void readAndWriteToFile(String fileName) throws IOException {
        File file = new File(fileName);
        if (!file.exists()) {
            throw new FileNotFoundException("FileNotFoundError: " + fileName);
        }

        try (FileInputStream fis = new FileInputStream(file);
             FileOutputStream fos = new FileOutputStream(File.createTempFile("temp", ".tmp"))) {

            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }
        }
    }
}