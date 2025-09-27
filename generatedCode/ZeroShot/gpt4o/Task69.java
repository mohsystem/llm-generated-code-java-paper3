package ZeroShot.gpt4o;
import java.io.File;

public class Task69 {
    public static void main(String[] args) {
        if (args.length != 5) {
            System.out.println("Please provide exactly 5 file paths.");
            return;
        }
        for (String filePath : args) {
            System.out.println(deleteFile(filePath) ? "File deleted: " + filePath : "Failed to delete: " + filePath);
        }
    }

    public static boolean deleteFile(String filePath) {
        File file = new File(filePath);
        if (!file.exists()) {
            System.out.println("File does not exist: " + filePath);
            return false;
        }
        return file.delete();
    }
}