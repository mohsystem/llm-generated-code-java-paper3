package Vanilla.llama31;
public class Task159 {
    public static void main(String[] args) {
        int[] buffer = new int[10];
        for (int i = 0; i < 10; i++) {
            buffer[i] = i * 10;
        }
        System.out.println("Buffer contents:");
        for (int i = 0; i < 10; i++) {
            System.out.print(buffer[i] + " ");
        }
        System.out.println();

        // Test cases
        System.out.println("Value at index 3: " + readBuffer(buffer, 3));
        System.out.println("Value at index 7: " + readBuffer(buffer, 7));
        System.out.println("Value at index 9: " + readBuffer(buffer, 9));
        System.out.println("Value at index 10 (out of bounds): " + readBuffer(buffer, 10));
        System.out.println("Value at index -1 (out of bounds): " + readBuffer(buffer, -1));
    }

    public static int readBuffer(int[] buffer, int index) {
        if (index < 0 || index >= buffer.length) {
            return -1; // Out of bounds
        }
        return buffer[index];
    }
}