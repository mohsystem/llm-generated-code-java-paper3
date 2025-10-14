package ourMethodv2.gpt4o;
import java.io.File;
import java.io.IOException;

public class Task101 {
    public static void createAndMakeExecutable(String fileName) throws IOException {
        File file = new File(fileName);
        if (!file.exists()) {
            if (file.createNewFile()) {
                file.setExecutable(true, false);
            }
        }
    }

    public static void main(String[] args) {
        try {
            createAndMakeExecutable("script.sh");
            createAndMakeExecutable("test1.sh");
            createAndMakeExecutable("test2.sh");
            createAndMakeExecutable("test3.sh");
            createAndMakeExecutable("test4.sh");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}