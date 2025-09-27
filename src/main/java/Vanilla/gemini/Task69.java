package Vanilla.gemini;
import java.io.File;
import java.io.IOException;

class Task69 {
    public static boolean deleteFile(String filePath) {
        File file = new File(filePath);
        if (file.exists()) {
            return file.delete();
        }
        return false;
    }

    public static void main(String[] args) {
        if (args.length > 0) {
            for (String arg : args) {
                if (deleteFile(arg)) {
                    System.out.println("File deleted successfully: " + arg);
                } else {
                    System.out.println("Failed to delete file: " + arg);
                }
            }

        } else {
             System.out.println("No file path provided.");
           
             // Test cases (when no command-line arguments are provided)
             System.out.println(deleteFile("test1.txt")); // Create and delete test1.txt 
             try {
                 new File("test2.txt").createNewFile();
             } catch (IOException e) {
                 System.out.println("Failed to create test file: " + e.getMessage());
             }
             System.out.println(deleteFile("test2.txt"));
             System.out.println(deleteFile("non_existent_file.txt"));
             System.out.println(deleteFile("test_directory")); // Try to delete a directory (should fail)
             try {
                new File("test_directory").mkdir(); 
                new File("test_directory/test3.txt").createNewFile();
             } catch (IOException e) {
                 System.out.println("Failed to create test directory/file: " + e.getMessage());
             }
             System.out.println(deleteFile("test_directory/test3.txt"));
        }
    }
}