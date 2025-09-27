package ourMethod.codestral;
import java.io.File;

public class Task69 {
    public static void main(String[] args) {
        deleteFile(args[0]);
    }

    public static void deleteFile(String filePath) {
        File file = new File(filePath);
        if(file.exists() && !file.isDirectory()) {
            file.delete();
        }
    }
}