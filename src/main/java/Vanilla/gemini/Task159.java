package Vanilla.gemini;
import java.util.Scanner;

public class Task159 {

    public static String readFromBuffer(int[] buffer, int index) {
        if (index >= 0 && index < buffer.length) {
            return String.valueOf(buffer[index]);
        } else {
            return "Error: Index out of bounds";
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] buffer = new int[10];
        for (int i = 0; i < buffer.length; i++) {
            buffer[i] = i * 10;
        }

        System.out.println("Test cases:");
        System.out.println("readFromBuffer(buffer, 5): " + readFromBuffer(buffer, 5));
        System.out.println("readFromBuffer(buffer, 0): " + readFromBuffer(buffer, 0));
        System.out.println("readFromBuffer(buffer, 9): " + readFromBuffer(buffer, 9));
        System.out.println("readFromBuffer(buffer, -1): " + readFromBuffer(buffer, -1));
        System.out.println("readFromBuffer(buffer, 10): " + readFromBuffer(buffer, 10));

        scanner.close();
    }
}