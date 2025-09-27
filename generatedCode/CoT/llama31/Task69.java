package CoT.llama31;
import java.io.File;
import java.io.IOException;

public class Task69 {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java Task69 <file_path>");
            return;
        }
        String filePath = args[0];
        File file = new File(filePath);
        if (file.delete()) {
            System.out.println("File deleted successfully");
        } else {
            System.out.println("Failed to delete the file");
        }
    }

    public static boolean deleteFile(String filePath) {
        File file = new File(filePath);
        return file.delete();
    }
}