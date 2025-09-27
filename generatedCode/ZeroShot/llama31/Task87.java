package ZeroShot.llama31;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Task87 {
    public static int binarySearch(int[] array, int x) {
        int low = 0;
        int high = array.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (array[mid] == x) {
                return mid;
            } else if (array[mid] < x) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] array = {3, 4, 5, 6, 7, 8, 9};
        int[] testCases = {4, 6, 9, 10, 3};

        for (int testCase : testCases) {
            long startTime = System.nanoTime();
            int result = binarySearch(array, testCase);
            long endTime = System.nanoTime();
            double executionTime = (endTime - startTime) / 1e9;

            try (PrintWriter writer = new PrintWriter(new FileWriter("execution_time.txt", true))) {
                writer.println("Execution time for searching " + testCase + ": " + executionTime + " seconds");
                if (result != -1) {
                    writer.println("Element " + testCase + " found at index " + result);
                } else {
                    writer.println("Element " + testCase + " not found");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}