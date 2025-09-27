package ourMethod.llama31;
import java.io.File;
import java.io.IOException;

public class Task69 {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java Task69 <filename>");
            return;
        }

        String filePath = args[0];
        File file = new File(filePath);

        // Check if the file exists and is a file (not a directory)
        if (file.exists() && file.isFile()) {
            try {
                if (file.delete()) {
                    System.out.println("File deleted successfully");
                } else {
                    System.out.println("Failed to delete the file");
                }
            } catch (SecurityException e) {
                System.out.println("Permission denied to delete the file");
            }
        } else {
            System.out.println("The specified file does not exist or is not a file");
        }
    }
}