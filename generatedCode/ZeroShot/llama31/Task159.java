package ZeroShot.llama31;
public class Task159 {
    public static void main(String[] args) {
        int[] buffer = new int[10];
        for (int i = 0; i < 10; i++) {
            buffer[i] = i * 10;
        }
        System.out.println("Buffer values: ");
        for (int i = 0; i < 10; i++) {
            System.out.print(buffer[i] + " ");
        }
        System.out.println();

        // Test cases
        for (int i = 0; i < 5; i++) {
            int index = i;
            try {
                System.out.println("Value at index " + index + ": " + readFromBuffer(buffer, index));
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Index " + index + " is out of bounds.");
            }
        }
    }

    public static int readFromBuffer(int[] buffer, int index) {
        if (index < 0 || index >= buffer.length) {
            throw new IndexOutOfBoundsException("Index is out of bounds.");
        }
        return buffer[index];
    }
}