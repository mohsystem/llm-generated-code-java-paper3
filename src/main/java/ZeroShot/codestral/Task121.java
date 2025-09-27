package ZeroShot.codestral;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
//todo class, interface, enum, or record expected
//class, interface, enum, or record expected
//class, interface, enum, or record expected
//class, interface, enum, or record expected
//class, interface, enum, or record expected
//class, interface, enum, or record expected
//class, interface, enum, or record expected
//class, interface, enum, or record expected
class Task121 {
    private static final String UPLOAD_DIR = "path";

    @PostMapping("/uploadFile")
    public String uploadFile(@RequestParam("file") MultipartFile file) {
        try {
            // save file to a directory
            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOAD_DIR + file.getOriginalFilename());
            Files.write(path, bytes);
            return "File uploaded successfully!";
        } catch (IOException e) {
            e.printStackTrace();
            return "Error uploading file!";
        }
    }
}