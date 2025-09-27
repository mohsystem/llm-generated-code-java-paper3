package ZeroShot.gpt4o;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class Task87 {

    public static int binarySearch(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (array[mid] == target) {
                return mid;
            } else if (array[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static void writeExecutionTimeToFile(long executionTime) {
        try (FileWriter writer = new FileWriter("execution_time_java.txt")) {
            writer.write("Execution Time: " + executionTime + " ns");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] testCases = {5, 1, 10, 11, -1};

        Arrays.sort(array); // Ensure the array is sorted for binary search

        for (int target : testCases) {
            long startTime = System.nanoTime();
            int result = binarySearch(array, target);
            long endTime = System.nanoTime();
            long executionTime = endTime - startTime;

            System.out.println("Target: " + target + ", Result: " + result);
            writeExecutionTimeToFile(executionTime);
        }
    }
}