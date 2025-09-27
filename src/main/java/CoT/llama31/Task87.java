package CoT.llama31;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Task87 {
    public static int binarySearch(int array[], int x, int low, int high) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (array[mid] == x)
                return mid;
            if (array[mid] < x)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return -1;
    }

    public static void main(String args[]) throws IOException {
        int array[] = {3, 4, 5, 6, 7, 8, 9};
        int n = array.length;

        // Test cases
        int[] testCases = {4, 9, 1, 7, 10};

        for (int x : testCases) {
            long startTime = System.nanoTime();
            int result = binarySearch(array, x, 0, n - 1);
            long endTime = System.nanoTime();
            long executionTime = endTime - startTime;

            // Write execution time to a temporary file
            try (PrintWriter out = new PrintWriter(new FileWriter("execution_time.txt", true))) {
                out.println("Execution time for " + x + ": " + executionTime + " nanoseconds");
            }

            if (result == -1)
                System.out.println("Element " + x + " is not present in array");
            else
                System.out.println("Element " + x + " is present at index " + result);
        }
    }
}