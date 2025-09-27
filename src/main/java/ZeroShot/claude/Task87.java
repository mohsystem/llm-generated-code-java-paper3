package ZeroShot.claude;

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
            }
            if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        try {
            FileWriter writer = new FileWriter("execution_time.txt");
            
            // Test cases
            int[][] testArrays = {
                {1, 3, 5, 7, 9, 11, 13, 15},
                {2, 4, 6, 8, 10, 12, 14, 16, 18},
                {1, 2, 3, 4, 5},
                {10, 20, 30, 40, 50, 60},
                {1, 3, 5, 7, 9, 11, 13, 15, 17, 19}
            };
            
            int[] searchValues = {7, 14, 5, 30, 20};
            
            for (int i = 0; i < testArrays.length; i++) {
                long startTime = System.nanoTime();
                int result = binarySearch(testArrays[i], searchValues[i]);
                long endTime = System.nanoTime();
                long duration = endTime - startTime;
                
                writer.write("Test case " + (i+1) + ":\\n");
                writer.write("Array: " + Arrays.toString(testArrays[i]) + "\\n");
                writer.write("Search value: " + searchValues[i] + "\\n");
                writer.write("Result index: " + result + "\\n");
                writer.write("Execution time: " + duration + " nanoseconds\\n\\n");
            }
            
            writer.close();
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }
}
