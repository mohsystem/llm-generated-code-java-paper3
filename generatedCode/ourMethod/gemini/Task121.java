package ourMethod.gemini;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class Task121 {

    public static String uploadFile(String uploadDirectory, String fileName, byte[] fileData) throws IOException {
        Path uploadPath = Paths.get(uploadDirectory);

        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }


        if (fileName == null || fileName.isEmpty() || fileName.contains("..") || fileName.contains("/") || fileName.contains("\")) {
           throw new IllegalArgumentException("Invalid file name.");
        }

        Path filePath = uploadPath.resolve(fileName);

        Files.copy(new java.io.ByteArrayInputStream(fileData), filePath, StandardCopyOption.REPLACE_EXISTING);

        return filePath.toString();
    }

    public static void main(String[] args) {
        String uploadDir = "uploads";
        try {
            uploadFile(uploadDir, "test1.txt", "Test file 1 content".getBytes());
            System.out.println("test1.txt uploaded successfully.");

            uploadFile(uploadDir, "test2.pdf", "Test file 2 content".getBytes());
            System.out.println("test2.pdf uploaded successfully.");

            uploadFile(uploadDir, "document.docx", "Test file 3 content".getBytes());
            System.out.println("document.docx uploaded successfully.");


            uploadFile(uploadDir, "image.png", "Test file 4 content".getBytes());
            System.out.println("image.png uploaded successfully.");

            uploadFile(uploadDir, "video.mp4", "Test file 5 content".getBytes());
            System.out.println("video.mp4 uploaded successfully.");


        } catch (IOException e) {
            System.err.println("Error uploading file: " + e.getMessage());
        }
    }
}