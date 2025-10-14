import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Task50 {

    public static String uploadFile(String filePath, byte[] fileContent) {
        try {
            // Normalize file path to prevent directory traversal
            File file = new File(filePath).getCanonicalFile();
            
            // Ensure file is within a specific directory (e.g., "uploads")
            File uploadsDir = new File("uploads").getCanonicalFile();
            if (!file.getParentFile().equals(uploadsDir)) {
                return "Invalid file path";
            }

            // Write the file
            try (FileOutputStream fos = new FileOutputStream(file)) {
                fos.write(fileContent);
            }
            return "File uploaded successfully: " + file.getName();
        } catch (IOException e) {
            return "File upload failed: " + e.getMessage();
        }
    }

    public static void main(String[] args) {
        byte[] content = "Sample file content".getBytes(StandardCharsets.UTF_8);
        
        System.out.println(uploadFile("uploads/test1.txt", content));
        System.out.println(uploadFile("uploads/test2.txt", content));
        System.out.println(uploadFile("uploads/test3.txt", content));
        System.out.println(uploadFile("uploads/test4.txt", content));
        System.out.println(uploadFile("uploads/test5.txt", content));
    }
}