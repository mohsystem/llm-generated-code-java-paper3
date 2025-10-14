package Vanilla.openai;
import java.io.*;

public class Task127 {
    public static boolean copyFile(String sourcePath, String destinationPath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(sourcePath));
             BufferedWriter writer = new BufferedWriter(new FileWriter(destinationPath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line);
                writer.newLine();
            }
            return true;
        } catch (IOException e) {
            System.err.println("An error occurred: " + e.getMessage());
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(copyFile("test1.txt", "temp1.txt"));
        System.out.println(copyFile("test2.txt", "temp2.txt"));
        System.out.println(copyFile("test3.txt", "temp3.txt"));
        System.out.println(copyFile("test4.txt", "temp4.txt"));
        System.out.println(copyFile("test5.txt", "temp5.txt"));
    }
}