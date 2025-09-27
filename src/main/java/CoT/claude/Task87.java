package CoT.claude;

import java.io.*;
import java.util.Arrays;

public class Task87 {
    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                return mid;
            }
            if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static void writeExecutionTime(long time) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("execution_time.txt"))) {
            writer.write("Execution time: " + time + " nanoseconds");
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        // Test cases
        int[][] testArrays = {
            {1, 3, 5, 7, 9, 11, 13, 15},
            {2, 4, 6, 8, 10, 12, 14},
            {1, 2, 3, 4, 5},
            {10, 20, 30, 40, 50, 60},
            {1}
        };
        int[] targets = {7, 12, 1, 45, 1};

        for (int i = 0; i < testArrays.length; i++) {
            long startTime = System.nanoTime();
            int result = binarySearch(testArrays[i], targets[i]);
            long endTime = System.nanoTime();
            
            System.out.println("Test case " + (i+1) + ":");
            System.out.println("Array: " + Arrays.toString(testArrays[i]));
            System.out.println("Target: " + targets[i]);
            System.out.println("Result: " + result);
            
            writeExecutionTime(endTime - startTime);
            System.out.println("Execution time written to file\\n");
        }
    }
}
