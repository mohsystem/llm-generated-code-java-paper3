package ourMethod.gemini;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class Task50 {

    public static String uploadFile(String uploadDirectory, String fileName, byte[] fileData) {
        try {
            // Create upload directory if it doesn't exist
            File directory = new File(uploadDirectory);
            if (!directory.exists()) {
                directory.mkdirs();
            }

            // Specify the file path
            Path filePath = Paths.get(uploadDirectory, fileName);

            // Write file data to the specified path
            Files.write(filePath, fileData);

            return "File uploaded successfully!";

        } catch (IOException e) {
            return "Error uploading file: " + e.getMessage();
        }
    }


    public static void main(String[] args) {
        String uploadDir = "uploads";

        // Test cases
        System.out.println(uploadFile(uploadDir, "test1.txt", "Test file 1 content".getBytes()));
        System.out.println(uploadFile(uploadDir, "test2.pdf", "Test PDF content".getBytes()));
        System.out.println(uploadFile(uploadDir, "report.docx", "Word document content".getBytes()));
        System.out.println(uploadFile(uploadDir, "image.png", "Image data".getBytes()));
        System.out.println(uploadFile(uploadDir, "test_with_special_chars_<>&\"'.txt", "Test with special characters".getBytes()));

    }
}