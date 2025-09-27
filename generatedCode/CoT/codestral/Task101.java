package CoT.codestral;
import java.io.File;
import java.io.IOException;

public class Task101 {
    public static void main(String[] args) {
        createExecutableFile();
    }

    public static void createExecutableFile() {
        try {
            File file = new File("script.sh");
            if (file.createNewFile()) {
                if (file.setExecutable(true)) {
                    System.out.println("File script.sh created and made executable.");
                } else {
                    System.out.println("Failed to make the file executable.");
                }
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}