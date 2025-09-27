package ourMethod.llama31;
public class Task159 {
    public static void main(String[] args) {
        int bufferSize = 10;
        int[] buffer = new int[bufferSize];
        for (int i = 0; i < bufferSize; i++) {
            buffer[i] = i * 10;
        }

        // Test cases
        System.out.println("Buffer content:");
        for (int i = 0; i < bufferSize; i++) {
            System.out.print(buffer[i] + " ");
        }
        System.out.println();

        int[] indices = {0, 3, 7, 9};
        for (int index : indices) {
            if (index >= 0 && index < bufferSize) {
                System.out.println("Value at index " + index + ": " + buffer[index]);
            } else {
                System.out.println("Index " + index + " is out of bounds.");
            }
        }
    }
}