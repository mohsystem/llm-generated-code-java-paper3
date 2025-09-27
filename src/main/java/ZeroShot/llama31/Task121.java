package ZeroShot.llama31;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

public class Task121 {
    public static void main(String[] args) {
        String[] testFiles = {"test.jpg", "test.pdf", "test.exe", "test.zip", "test.txt"};
        for (String file : testFiles) {
            uploadFile(file, "uploads/");
        }
    }

    public static boolean uploadFile(String fileName, String uploadDir) {
        // Check if the file exists
        File file = new File(fileName);
        if (!file.exists()) {
            System.out.println("File does not exist.");
            return false;
        }

        // Restrict file types
        String[] allowedExtensions = {".jpg", ".pdf", ".txt"};
        if (!isAllowedExtension(file.getName(), allowedExtensions)) {
            System.out.println("File type not allowed.");
            return false;
        }

        // Generate a unique file name
        String newFileName = UUID.randomUUID().toString() + getFileExtension(file.getName());

        // Store the file outside of the document root
        Path uploadPath = Paths.get(uploadDir, newFileName);
        try {
            Files.copy(file.toPath(), uploadPath);
            System.out.println("File uploaded successfully as " + newFileName);
            return true;
        } catch (IOException e) {
            System.out.println("Error uploading file: " + e.getMessage());
            return false;
        }
    }

    private static boolean isAllowedExtension(String fileName, String[] allowedExtensions) {
        for (String extension : allowedExtensions) {
            if (fileName.endsWith(extension)) {
                return true;
            }
        }
        return false;
    }

    private static String getFileExtension(String fileName) {
        int dotIndex = fileName.lastIndexOf('.');
        if (dotIndex > 0) {
            return fileName.substring(dotIndex);
        }
        return "";
    }
}