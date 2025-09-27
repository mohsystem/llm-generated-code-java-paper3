package ourMethod.gpt4o;
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
        if (args.length == 0) {
            System.out.println("Please provide a file path as an argument.");
            return;
        }

        for (String filePath : args) {
            boolean isDeleted = deleteFile(filePath);
            if (isDeleted) {
                System.out.println("File deleted successfully: " + filePath);
            } else {
                System.out.println("Failed to delete file: " + filePath);
            }
        }
    }
}