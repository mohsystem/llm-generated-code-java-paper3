package Vanilla.llama31;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Task87 {
    public static int binarySearch(int[] array, int target) {
        int low = 0;
        int high = array.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (array[mid] == target) {
                return mid;
            } else if (array[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] array = {3, 4, 5, 6, 7, 8, 9};
        int[] targets = {4, 6, 8, 10, 5};

        for (int target : targets) {
            long startTime = System.nanoTime();
            int result = binarySearch(array, target);
            long endTime = System.nanoTime();
            long executionTime = endTime - startTime;

            try (PrintWriter out = new PrintWriter(new FileWriter("execution_time.txt", true))) {
                out.println("Target: " + target + ", Result: " + result + ", Execution Time: " + executionTime + " nanoseconds");
            } catch (IOException e) {
                System.err.println("Error writing to file: " + e.getMessage());
            }

            if (result != -1) {
                System.out.println("Element " + target + " is present at index " + result);
            } else {
                System.out.println("Element " + target + " not found");
            }
        }
    }
}