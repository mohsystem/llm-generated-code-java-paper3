package ourMethodv2.gpt4o;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class Task121 {
    public static String uploadFile(File sourceFile, String destinationDirectory) {
        try {
            File destDir = new File(destinationDirectory);
            if (!destDir.exists()) {
                destDir.mkdirs();
            }
            File destFile = new File(destDir, sourceFile.getName());
            Files.copy(sourceFile.toPath(), destFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
            return "Upload Successful: " + destFile.getAbsolutePath();
        } catch (IOException e) {
            return "Upload Failed: " + e.getMessage();
        }
    }

    public static void main(String[] args) {
        File file1 = new File("path/to/file1.txt");
        File file2 = new File("path/to/file2.txt");
        File file3 = new File("path/to/file3.txt");
        File file4 = new File("path/to/file4.txt");
        File file5 = new File("path/to/file5.txt");

        System.out.println(uploadFile(file1, "uploads"));
        System.out.println(uploadFile(file2, "uploads"));
        System.out.println(uploadFile(file3, "uploads"));
        System.out.println(uploadFile(file4, "uploads"));
        System.out.println(uploadFile(file5, "uploads"));
    }
}