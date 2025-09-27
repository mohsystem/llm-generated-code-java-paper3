package Vanilla.llama31;
import java.io.File;

public class Task69 {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java Task69 <filename>");
            return;
        }
        File file = new File(args[0]);
        if (file.delete()) {
            System.out.println(args[0] + " is successfully deleted.");
        } else {
            System.out.println("File " + args[0] + " does not exist or could not be deleted.");
        }
    }

    public static boolean deleteFile(String filePath) {
        File file = new File(filePath);
        return file.delete();
    }
}