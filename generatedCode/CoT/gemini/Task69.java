package CoT.gemini;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Task69 {

    public static boolean deleteFile(String filePath) {
        try {
            Path path = Paths.get(filePath);
            if (!Files.exists(path)) {
                return false; // File doesn't exist
            }

            Files.delete(path);
            return true;
        } catch (InvalidPathException e) {
            System.err.println("Invalid file path: " + e.getMessage());
            return false;
        } catch (IOException e) {
            System.err.println("Error deleting file: " + e.getMessage());
            return false;
        } catch (SecurityException e) {
            System.err.println("Insufficient permissions to delete file: " + e.getMessage());
            return false;
        }
    }

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Please provide file path(s) as command-line arguments.");
            return;
        }

         for (String arg : args) {
             if (deleteFile(arg)) {
                 System.out.println("File deleted successfully: " + arg);
             } else {
                 System.err.println("Failed to delete file: " + arg);
             }
         }
    }
}