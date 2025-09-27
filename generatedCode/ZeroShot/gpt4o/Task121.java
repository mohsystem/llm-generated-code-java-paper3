package ZeroShot.gpt4o;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class Task121 {
    public static boolean uploadFile(File sourceFile, String destinationDir) {
        if (sourceFile == null || destinationDir == null || !sourceFile.exists() || !sourceFile.isFile()) {
            return false;
        }
        File destDir = new File(destinationDir);
        if (!destDir.exists() || !destDir.isDirectory()) {
            return false;
        }
        File destinationFile = new File(destDir, sourceFile.getName());
        try {
            Files.copy(sourceFile.toPath(), destinationFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(uploadFile(new File("test1.txt"), "/path/to/destination"));
        System.out.println(uploadFile(new File("test2.txt"), "/path/to/destination"));
        System.out.println(uploadFile(new File("test3.txt"), "/path/to/destination"));
        System.out.println(uploadFile(new File("test4.txt"), "/path/to/destination"));
        System.out.println(uploadFile(new File("test5.txt"), "/path/to/destination"));
    }
}