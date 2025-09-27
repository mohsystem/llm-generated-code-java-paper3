package CoT.gpt4o;
import java.util.Scanner;

public class Task159 {

    public static void main(String[] args) {
        // Test cases
        runTest(new int[]{1, 2, 3, 4, 5}, 2); // Valid index
        runTest(new int[]{10, 20, 30, 40, 50}, 0); // First index
        runTest(new int[]{100, 200, 300}, 2); // Last index
        runTest(new int[]{7, 8, 9}, 5); // Invalid index
        runTest(new int[]{11, 22, 33}, -1); // Invalid index
    }

    public static Integer readBuffer(int[] buffer, int index) {
        if (index < 0 || index >= buffer.length) {
            return null; // Out of bounds
        }
        return buffer[index];
    }

    public static void runTest(int[] buffer, int index) {
        Integer result = readBuffer(buffer, index);
        if (result != null) {
            System.out.println("Value at index " + index + ": " + result);
        } else {
            System.out.println("Invalid index: " + index);
        }
    }
}