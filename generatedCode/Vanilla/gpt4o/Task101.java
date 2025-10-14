package Vanilla.openai;
import java.io.File;
import java.io.IOException;

public class Task101 {

    public static void createAndMakeExecutable(String fileName) throws IOException {
        File file = new File(fileName);
        if (!file.exists()) {
            file.createNewFile();
        }
        file.setExecutable(true);
    }

    public static void main(String[] args) {
        try {
            createAndMakeExecutable("script.sh");
            System.out.println("File script.sh created and made executable.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}