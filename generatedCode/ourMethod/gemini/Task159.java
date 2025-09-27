package ourMethod.gemini;
import java.util.Scanner;

public class Task159 {

    public static String readFromBuffer(int[] buffer, int index) {
        if (buffer == null) {
            return "Error: Buffer is null.";
        }
        if (index < 0 || index >= buffer.length) {
            return "Error: Index out of bounds.";
        }
        return String.valueOf(buffer[index]);
    }

    public static void main(String[] args) {
        // Test cases
        int[] buffer1 = new int[5];
        for (int i = 0; i < buffer1.length; i++) {
            buffer1[i] = i * 10;
        }

        System.out.println(readFromBuffer(buffer1, 2)); // Output: 20
        System.out.println(readFromBuffer(buffer1, -1)); // Output: Error: Index out of bounds.
        System.out.println(readFromBuffer(buffer1, 5)); // Output: Error: Index out of bounds.
        System.out.println(readFromBuffer(null, 2)); // Output: Error: Buffer is null.

        int[] buffer2 = new int[0];
        System.out.println(readFromBuffer(buffer2, 0)); // Output: Error: Index out of bounds.


    }
}