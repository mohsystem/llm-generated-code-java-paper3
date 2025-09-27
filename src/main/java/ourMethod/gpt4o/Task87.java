package ourMethod.gpt4o;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Task87 {

    public static int binarySearch(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (array[mid] == target) {
                return mid;
            }
            if (array[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static void logExecutionTime(long executionTime) {
        try {
            File tempFile = File.createTempFile("binary_search_execution_time", ".log");
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
            writer.write("Execution time: " + executionTime + " nanoseconds");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        // Test cases
        int[] testCases = {1, 5, 10, -1, 11};
        for (int target : testCases) {
            long startTime = System.nanoTime();
            int result = binarySearch(array, target);
            long endTime = System.nanoTime();
            long executionTime = endTime - startTime;

            System.out.println("Target: " + target + " Index: " + result);
            logExecutionTime(executionTime);
        }
    }
}