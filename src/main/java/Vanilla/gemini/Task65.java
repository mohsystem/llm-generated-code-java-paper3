package Vanilla.gemini;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Task65 {

    public static String readFileData(String filename) {
        try {
            File file = new File(filename);
            if (!file.exists()) {
                return "File not found.";
            }
            Scanner scanner = new Scanner(file);
            StringBuilder data = new StringBuilder();
            while (scanner.hasNextLine()) {
                data.append(scanner.nextLine()).append("\n");
            }
            scanner.close();
            return data.toString();
        } catch (FileNotFoundException e) {
            return "Error reading file.";
        }
    }

    public static void main(String[] args) {
        System.out.println(readFileData("test1.txt"));
        System.out.println(readFileData("test2.txt"));
        System.out.println(readFileData("nonexistent.txt"));
        System.out.println(readFileData("test3.txt"));
        System.out.println(readFileData("test4.txt"));


    }
}