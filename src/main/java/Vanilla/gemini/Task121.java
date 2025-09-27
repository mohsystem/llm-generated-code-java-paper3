package Vanilla.gemini;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Scanner;

class Task121 {
    public static void uploadFile(String sourceFilePath, String destinationDirectory) throws IOException {
        Path sourcePath = Paths.get(sourceFilePath);
        Path destinationPath = Paths.get(destinationDirectory);

        if (!Files.exists(destinationPath)) {
            Files.createDirectories(destinationPath);
        }

        Files.copy(sourcePath, destinationPath.resolve(sourcePath.getFileName()), StandardCopyOption.REPLACE_EXISTING);

        System.out.println("File uploaded successfully to: " + destinationPath.resolve(sourcePath.getFileName()));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            uploadFile("test1.txt", "uploads");
            uploadFile("test2.txt", "uploads");
            uploadFile("test3.txt", "uploads/subdir");
            uploadFile("test4.txt", "uploads/subdir");
            uploadFile("test5.txt", "newuploads");

        } catch (IOException e) {
            System.err.println("Error uploading file: " + e.getMessage());
        }
        scanner.close();
    }
}