package ZeroShot.llama31;
// Task50.java
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@SpringBootApplication
@RestController
public class Task50 {

    public static void main(String[] args) {
        SpringApplication.run(Task50.class, args);
    }

    @PostMapping("/upload")
    public String uploadFile(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return "File is empty";
        }

        try {
            Path root = Paths.get("uploads");
            Files.createDirectories(root);
            Path resolve = root.resolve(file.getOriginalFilename());
            Files.copy(file.getInputStream(), resolve, StandardCopyOption.REPLACE_EXISTING);
            return "File uploaded successfully";
        } catch (IOException e) {
            return "Error uploading file: " + e.getMessage();
        }
    }
}