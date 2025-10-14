package CoT.openai;
import java.io.File;
import java.io.IOException;

public class Task101 {
    public static void main(String[] args) {
        // Test cases
        createAndMakeExecutable("script.sh");
        createAndMakeExecutable("example.sh");
        createAndMakeExecutable("testScript.sh");
        createAndMakeExecutable("myScript.sh");
        createAndMakeExecutable("demo.sh");
    }

    public static void createAndMakeExecutable(String fileName) {
        try {
            File file = new File(fileName);
            if (file.createNewFile()) {
                if (file.setExecutable(true)) {
                    System.out.println(fileName + " is created and made executable.");
                } else {
                    System.out.println("Failed to make " + fileName + " executable.");
                }
            } else {
                System.out.println(fileName + " already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred while creating " + fileName + ": " + e.getMessage());
        }
    }
}