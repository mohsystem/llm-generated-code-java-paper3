package ourMethod.llama31;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Task87 {
    public static void main(String[] args) {
        int[] array = {3, 4, 5, 6, 7, 8, 9};
        int x = 4;

        long startTime = System.nanoTime();
        int result = binarySearch(array, x, 0, array.length - 1);
        long endTime = System.nanoTime();

        try (PrintWriter writer = new PrintWriter(new FileWriter("execution_time.txt"))) {
            writer.println("Execution time: " + (endTime - startTime) + " nanoseconds");
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }

        if (result != -1) {
            System.out.println("Element is present at index " + result);
        } else {
            System.out.println("Not found");
        }
    }

    public static int binarySearch(int array[], int x, int low, int high) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (x == array[mid]) {
                return mid;
            } else if (x < array[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
}