package ZeroShot.openai;
import java.util.Scanner;

public class Task159 {
    private int[] buffer;

    public Task159(int size) {
        buffer = new int[size];
        for (int i = 0; i < size; i++) {
            buffer[i] = i;  // Initialize buffer with some data
        }
    }

    public int readFromBuffer(int index) {
        if (index < 0 || index >= buffer.length) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        return buffer[index];
    }

    public static void main(String[] args) {
        Task159 task = new Task159(10);
        int[] testIndexes = {0, 5, 9, -1, 10};
        for (int index : testIndexes) {
            try {
                System.out.println("Value at index " + index + ": " + task.readFromBuffer(index));
            } catch (IndexOutOfBoundsException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}