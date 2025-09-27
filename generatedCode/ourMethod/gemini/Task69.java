package ourMethod.gemini;
import java.io.File;
import java.io.IOException;

public class Task69 {

    public static boolean deleteFile(String filePath) {
        File file = new File(filePath);

        if (!file.exists()) {
            return false;
        }

        if (file.isDirectory()) {
            return false;
        }


        return file.delete();
    }

    public static void main(String[] args) throws IOException {
        // Test cases
        System.out.println("Test case 1: " + deleteFile("test1.txt")); // File exists
        File test2 = new File("test2.txt");
        test2.createNewFile();
        System.out.println("Test case 2: " + deleteFile("test2.txt")); // File created and deleted
        System.out.println("Test case 3: " + deleteFile("nonexistent.txt")); // File does not exist
        File test4 = new File("test_dir");
        test4.mkdir();
        System.out.println("Test case 4: " + deleteFile("test_dir")); // Path is a directory
        File test5 = new File("test3.txt");
        test5.createNewFile();
        test5.setReadOnly();
        System.out.println("Test case 5: " + deleteFile("test3.txt")); // File is read-only (may fail on some systems)

        // Clean up test directory if it still exists (e.g., if setReadOnly failed)
        if (test4.exists()) {
            test4.delete();
        }

        if (test5.exists()) {
            test5.setWritable(true); // Make writable before attempting to delete
            test5.delete();
        }

    }
}