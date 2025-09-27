package ourMethod.gpt4o;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Task121 {
    public static String uploadFile(byte[] fileContent, String fileName) {
        // Define the directory where files will be uploaded
        String uploadDirectory = "uploads";
        Path uploadPath = Paths.get(uploadDirectory);

        try {
            // Create the directory if it doesn't exist
            if (!Files.exists(uploadPath)) {
                Files.createDirectories(uploadPath);
            }

            // Ensure fileName is sanitized and doesn't contain any path traversal
            fileName = Paths.get(fileName).getFileName().toString();

            // Define the full path where the file will be saved
            Path filePath = uploadPath.resolve(fileName);

            // Ensure not to overwrite existing files
            if (Files.exists(filePath)) {
                throw new FileAlreadyExistsException("File already exists: " + fileName);
            }

            // Write the file to the specified path
            try (FileOutputStream fos = new FileOutputStream(filePath.toFile())) {
                fos.write(fileContent);
            }

            return "File uploaded successfully: " + fileName;
        } catch (IOException e) {
            return "Error uploading file: " + e.getMessage();
        }
    }

    public static void main(String[] args) {
        // Example test cases
        byte[] fileContent = "Sample content".getBytes();
        System.out.println(uploadFile(fileContent, "example1.txt"));
        System.out.println(uploadFile(fileContent, "example2.txt"));
        System.out.println(uploadFile(fileContent, "example3.txt"));
        System.out.println(uploadFile(fileContent, "example4.txt"));
        System.out.println(uploadFile(fileContent, "example5.txt"));
    }
}