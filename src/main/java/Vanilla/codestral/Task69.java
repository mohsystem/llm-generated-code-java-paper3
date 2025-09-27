package Vanilla.codestral;
import java.io.File;

public class Task69 {
    public static void deleteFile(String filePath) {
        File file = new File(filePath);
        if(file.exists()) {
            if(file.delete()) {
                System.out.println("File deleted successfully");
            } else {
                System.out.println("Failed to delete the file");
            }
        } else {
            System.out.println("File does not exist");
        }
    }

    public static void main(String[] args) {
        deleteFile(args[0]); // Test with command line arguments
    }
}