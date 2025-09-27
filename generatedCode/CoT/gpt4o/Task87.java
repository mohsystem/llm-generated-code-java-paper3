package CoT.gpt4o;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class Task87 {
    public static int binarySearch(int[] arr, int key) {
        int low = 0;
        int high = arr.length - 1;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            
            if (arr[mid] == key)
                return mid;
            
            if (arr[mid] < key)
                low = mid + 1;
            else
                high = mid - 1;
        }
        
        return -1;
    }
    
    public static void logExecutionTime(long time) {
        try {
            File tempFile = File.createTempFile("execution_time", ".txt");
            FileWriter writer = new FileWriter(tempFile);
            writer.write("Execution Time: " + time + " ns");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] testKeys = {5, 1, 10, 11, 0};

        for (int key : testKeys) {
            long startTime = System.nanoTime();
            int result = binarySearch(arr, key);
            long endTime = System.nanoTime();
            logExecutionTime(endTime - startTime);
            System.out.println("Key: " + key + " Result: " + result);
        }
    }
}