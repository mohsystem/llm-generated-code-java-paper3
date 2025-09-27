package CoT.llama31;
public class Task159 {
    public static void main(String[] args) {
        int bufferSize = 10;
        int[] buffer = new int[bufferSize];
        for (int i = 0; i < bufferSize; i++) {
            buffer[i] = i * 10;
        }

        System.out.println("Buffer contents:");
        for (int i = 0; i < bufferSize; i++) {
            System.out.print(buffer[i] + " ");
        }
        System.out.println();

        // Test cases
        int[] indices = {0, 3, 7, 9, 10};
        for (int index : indices) {
            try {
                System.out.println("Value at index " + index + ": " + readBuffer(buffer, index));
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Index " + index + " is out of bounds.");
            }
        }
    }

    public static int readBuffer(int[] buffer, int index) {
        if (index < 0 || index >= buffer.length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return buffer[index];
    }
}