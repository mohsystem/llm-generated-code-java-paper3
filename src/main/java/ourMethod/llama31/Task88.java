package ourMethod.llama31;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

public class Task88 {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            String randomString = UUID.randomUUID().toString();
            Path tempFilePath = createTemporaryFile(randomString);
            System.out.println("Temporary File Path: " + tempFilePath);
        }
    }

    public static Path createTemporaryFile(String content) {
        try {
            Path tempFile = java.nio.file.Files.createTempFile("temp", ".tmp");
            try (FileWriter writer = new FileWriter(tempFile.toFile(), java.nio.charset.StandardCharsets.UTF_8)) {
                writer.write(content);
            }
            return tempFile;
        } catch (IOException e) {
            throw new RuntimeException("Error creating temporary file", e);
        }
    }
}