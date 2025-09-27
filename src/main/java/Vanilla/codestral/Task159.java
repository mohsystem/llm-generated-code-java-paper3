package Vanilla.codestral;
public class Task159 {
    private static int[] buffer;

    public static void allocateBuffer(int size) {
        buffer = new int[size];
        // Initialize buffer with some values for testing
        for (int i = 0; i < size; i++) {
            buffer[i] = i;
        }
    }

    public static int readFromBuffer(int index) {
        if (index >= 0 && index < buffer.length) {
            return buffer[index];
        } else {
            throw new IndexOutOfBoundsException("Index is out of bounds.");
        }
    }

    public static void main(String[] args) {
        allocateBuffer(10);
        System.out.println(readFromBuffer(5)); // Should print 5
        System.out.println(readFromBuffer(10)); // Should throw an exception
    }
}