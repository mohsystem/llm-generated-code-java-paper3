package ourMethod.codestral;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Task101 {
    public static void createAndMakeExecutable(String fileName) throws IOException {
        File file = new File(fileName);
        if (file.createNewFile()) {
            System.out.println("File created: " + fileName);
            Path path = Paths.get(fileName);
            Files.setPosixFilePermissions(path, java.nio.file.attribute.PosixFilePermissions.fromString("rwxr-x---"));
            System.out.println("File made executable: " + fileName);
        } else {
            System.out.println("File already exists.");
        }
    }

    public static void main(String[] args) {
        try {
            createAndMakeExecutable("script.sh");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}