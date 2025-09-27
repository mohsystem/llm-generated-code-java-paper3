package CoT.codestral;
import java.io.*;
import java.nio.file.*;

public class Task127 {
    public static void copyFile(String src, String dest) {
        try {
            Files.copy(Paths.get(src), Paths.get(dest), StandardCopyOption.REPLACE_EXISTING);
            System.out.println("File copied successfully.");
        } catch (NoSuchFileException e) {
            System.out.println("No such file/directory exists");
        } catch (DirectoryNotEmptyException e) {
            System.out.println("Destination directory is not empty");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        copyFile("/path/to/source/file", "/path/to/destination/file");
        copyFile("/path/to/nonexistent/file", "/path/to/destination/file");
        copyFile("/path/to/source/file", "/path/to/nonexistent/directory");
    }
}