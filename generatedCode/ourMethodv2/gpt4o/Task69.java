package ourMethodv2.gpt4o;
import java.io.File;
import java.io.IOException;

public class Task69 {
    public static boolean deleteFile(String filePath) {
        File file = new File(filePath);
        if (!file.exists()) {
            System.out.println("File does not exist.");
            return false;
        }
        if (!file.isFile()) {
            System.out.println("Not a valid file.");
            return false;
        }
        return file.delete();
    }

    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Please provide file path as an argument.");
            return;
        }

        for (String filePath : args) {
            boolean result = deleteFile(filePath);
            System.out.println("File deletion for " + filePath + ": " + (result ? "Success" : "Failure"));
        }
    }
}