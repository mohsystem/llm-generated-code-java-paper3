package ZeroShot.gemini;
import java.io.File;

public class Task69 {

    public static boolean deleteFile(String filePath) {
        File file = new File(filePath);
        if (file.exists()) {
            return file.delete();
        }
        return false;
    }

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Please provide file path as command line argument.");
            return;
        }

        String filePath = args[0];
       
        if (deleteFile(filePath)) {
            System.out.println("File deleted successfully.");
        } else {
            System.out.println("Failed to delete file.");
        }


    }
}