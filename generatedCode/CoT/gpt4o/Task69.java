package CoT.openai;
import java.io.File;

public class Task69 {
    public static boolean deleteFile(String filePath) {
        File file = new File(filePath);
        if (file.exists() && file.isFile()) {
            return file.delete();
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(deleteFile("test1.txt")); // Replace with valid file paths for testing
        System.out.println(deleteFile("test2.txt"));
        System.out.println(deleteFile("test3.txt"));
        System.out.println(deleteFile("test4.txt"));
        System.out.println(deleteFile("test5.txt"));
    }
}