package CoT.gemini;
import java.util.Scanner;

public class Task159 {

    public static String readBufferAtIndex(int[] buffer, int index) {
        if (index >= 0 && index < buffer.length) {
            return String.valueOf(buffer[index]);
        } else {
            return "Index out of bounds";
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Test cases
        int[] buffer1 = {1, 2, 3, 4, 5};
        System.out.println(readBufferAtIndex(buffer1, 2)); // Output: 3
        System.out.println(readBufferAtIndex(buffer1, 5)); // Output: Index out of bounds

        int[] buffer2 = {10, 20, 30};
        System.out.println(readBufferAtIndex(buffer2, 0)); // Output: 10
        System.out.println(readBufferAtIndex(buffer2, -1)); // Output: Index out of bounds

        int[] buffer3 = new int[0];
        System.out.println(readBufferAtIndex(buffer3, 0)); // Output: Index out of bounds


        // Example usage with dynamic allocation and user input
        System.out.print("Enter the size of the buffer: ");
        int size = scanner.nextInt();

        if (size <= 0) {
            System.out.println("Invalid buffer size");
            return;
        }


        int[] buffer = new int[size];
        System.out.print("Enter the buffer elements: ");
        for (int i = 0; i < size; i++) {
            buffer[i] = scanner.nextInt();
        }

        System.out.print("Enter the index to read: ");
        int index = scanner.nextInt();

        System.out.println(readBufferAtIndex(buffer, index));

        scanner.close();
    }
}