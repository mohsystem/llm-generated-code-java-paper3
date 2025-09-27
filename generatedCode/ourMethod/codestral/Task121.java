package ourMethod.codestral;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class Task121 {
    public static void uploadFile(InputStream fileStream, String filePath) throws IOException {
        Files.copy(fileStream, new File(filePath).toPath(), StandardCopyOption.REPLACE_EXISTING);
    }

    public static void main(String[] args) {
        // Test case
        try (InputStream fileStream = Task121.class.getResourceAsStream("/test.txt")) {
            uploadFile(fileStream, "test.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}