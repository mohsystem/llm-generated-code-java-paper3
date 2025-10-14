package ZeroShot.openai;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Task101 {

    public static void createAndMakeExecutable(String fileName) {
        try {
            File file = new File(fileName);
            if (file.createNewFile()) {
                System.out.println("File created: " + fileName);
            } else {
                System.out.println("File already exists.");
            }

            if (file.setExecutable(true)) {
                System.out.println("File is now executable.");
            } else {
                System.out.println("Failed to make the file executable.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        createAndMakeExecutable("script1.sh");
        createAndMakeExecutable("script2.sh");
        createAndMakeExecutable("script3.sh");
        createAndMakeExecutable("script4.sh");
        createAndMakeExecutable("script5.sh");
    }
}