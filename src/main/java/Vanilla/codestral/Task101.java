package Vanilla.codestral;
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
                System.out.println("File is created!");
                if (file.setExecutable(true)) {
                    System.out.println("File is now executable!");
                } else {
                    System.out.println("Unable to set file as executable!");
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