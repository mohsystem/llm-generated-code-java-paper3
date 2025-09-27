package ourMethod.gpt4o;
import java.io.File;
import java.io.IOException;

public class Task101 {
    public static boolean createAndMakeExecutable(String fileName) {
        try {
            File file = new File(fileName);
            if (file.createNewFile()) {
                return file.setExecutable(true);
            }
            return false;
        } catch (IOException e) {
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(createAndMakeExecutable("script.sh"));
        System.out.println(createAndMakeExecutable("script2.sh"));
        System.out.println(createAndMakeExecutable("script3.sh"));
        System.out.println(createAndMakeExecutable("script4.sh"));
        System.out.println(createAndMakeExecutable("script5.sh"));
    }
}