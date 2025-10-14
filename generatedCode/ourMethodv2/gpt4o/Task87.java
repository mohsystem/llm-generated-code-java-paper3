package ourMethodv2.gpt4o;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class Task87 {

    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static void logExecutionTime(long time) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("temp_log.txt", true))) {
            writer.write("Execution time: " + time + " nanoseconds\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        int[] testArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] testCases = {3, 7, 1, 10, 11};

        for (int testCase : testCases) {
            long startTime = System.nanoTime();
            int result = binarySearch(testArray, testCase);
            long endTime = System.nanoTime();
            logExecutionTime(endTime - startTime);
            System.out.println("Result for " + testCase + ": " + result);
        }
    }
}