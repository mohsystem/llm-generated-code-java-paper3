package Vanilla.llama31;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Task70 {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Please provide the file path as a command line argument.");
            return;
        }
        String filePath = args[0];
        System.out.println(readFile(filePath));
    }

    public static String readFile(String filePath) {
        try {
            File file = new File(filePath);
            Scanner myReader = new Scanner(file);
            StringBuilder content = new StringBuilder();
            while (myReader.hasNextLine()) {
                content.append(myReader.nextLine()).append("\n");
            }
            myReader.close();
            return content.toString();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred: " + e.getMessage());
            return null;
        }
    }
}