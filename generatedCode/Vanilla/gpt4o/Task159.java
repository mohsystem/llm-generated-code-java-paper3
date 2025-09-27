package Vanilla.gpt4o;
import java.util.Scanner;

public class Task159 {
    private byte[] buffer;

    public Task159(int size) {
        buffer = new byte[size];
        for (int i = 0; i < size; i++) {
            buffer[i] = (byte) i; // Initializing with some data
        }
    }

    public byte readFromBuffer(int index) {
        if (index < 0 || index >= buffer.length) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        return buffer[index];
    }

    public static void main(String[] args) {
        Task159 task = new Task159(100); // Allocating buffer of size 100
        Scanner scanner = new Scanner(System.in);

        int[] testCases = {0, 50, 99, 100, -1}; // 5 test cases
        for (int index : testCases) {
            try {
                System.out.println("Reading from index " + index + ": " + task.readFromBuffer(index));
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}