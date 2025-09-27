package Vanilla.codestral;
import java.util.Scanner;
import java.io.IOException;

public class Task39 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the filename:");
        String filename = scanner.nextLine();
        displayFileContents(filename);
    }

    public static void displayFileContents(String filename) {
        try {
            Process process = Runtime.getRuntime().exec("cmd /c type " + filename);
            process.waitFor();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}