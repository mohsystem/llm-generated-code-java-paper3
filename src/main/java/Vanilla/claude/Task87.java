package Vanilla.claude;

import java.io.*;
import java.util.Arrays;

public class Task87 {
    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (arr[mid] == target)
                return mid;
                
            if (arr[mid] < target)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return -1;
    }
    
    public static void writeExecutionTime(long time) {
        try {
            File tempFile = File.createTempFile("execution_time", ".txt");
            FileWriter writer = new FileWriter(tempFile);
            writer.write("Execution time: " + time + " nanoseconds");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        // Test cases
        int[][] arrays = {
            {1, 3, 5, 7, 9, 11},
            {2, 4, 6, 8, 10},
            {1, 2, 3, 4, 5, 6, 7, 8},
            {10, 20, 30, 40, 50},
            {1}
        };
        int[] targets = {7, 10, 1, 25, 1};
        
        for (int i = 0; i < arrays.length; i++) {
            long startTime = System.nanoTime();
            int result = binarySearch(arrays[i], targets[i]);
            long endTime = System.nanoTime();
            
            System.out.println("Test case " + (i+1) + ":");
            System.out.println("Array: " + Arrays.toString(arrays[i]));
            System.out.println("Target: " + targets[i]);
            System.out.println("Result index: " + result);
            System.out.println();
            
            writeExecutionTime(endTime - startTime);
        }
    }
}
