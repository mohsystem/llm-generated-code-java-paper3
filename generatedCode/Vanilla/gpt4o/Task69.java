package Vanilla.openai;
import java.io.File;

public class Task69 {

    public static boolean deleteFile(String filePath) {
        File file = new File(filePath);
        return file.delete();
    }

    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Please provide a file path.");
            return;
        }

        String filePath = args[0];
        boolean result = deleteFile(filePath);
        System.out.println("File deleted: " + result);
    }
}