package ZeroShot.gemini;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


@SpringBootApplication
public class Task50 {

    public static void main(String[] args) {
        SpringApplication.run(Task50.class, args);
     }
}

@RestController
class FileUploadController {

    private static final String UPLOAD_DIR = "uploads";

    @PostMapping("/upload")
    public String uploadFile(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return "Please select a file to upload.";
        }

        try {
            createUploadDirectoryIfNotExists();

            Path path = Paths.get(UPLOAD_DIR + "/" + file.getOriginalFilename());
            Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);

            return "File uploaded successfully! Path: " + path.toAbsolutePath();
        } catch (IOException e) {
            return "Error uploading file: " + e.getMessage();
        }
    }



    private void createUploadDirectoryIfNotExists() throws IOException {
        File uploadDir = new File(UPLOAD_DIR);
        if (!uploadDir.exists()) {
            uploadDir.mkdir();
        }
    }
}