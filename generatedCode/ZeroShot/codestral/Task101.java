package ZeroShot.codestral;
import java.io.File;
import java.io.IOException;

public class Task101 {
    public static void main(String[] args) {
        createExecutableFile("script.sh");
    }

    public static void createExecutableFile(String fileName) {
        try {
            File file = new File(fileName);
            if (file.createNewFile()) {
                System.out.println("File is created!");
                if (file.setExecutable(true)) {
                    System.out.println("File is now executable!");
                } else {
                    System.out.println("Failed to set file as executable.");
                }
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}