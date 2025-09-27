package CoT.gemini;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Random;

public class Task87 {

    public static int binarySearch(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2; // Avoid potential overflow
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1; // Target not found
    }


    public static void main(String[] args) throws IOException {
        Path tempFile = Files.createTempFile("binary_search_timing", ".txt");

        int[] testCases = {10, 100, 1000, 10000, 100000};


        for (int size : testCases) {
            int[] arr = new int[size];
            Random random = new Random();
            for (int i = 0; i < size; i++) {
                arr[i] = random.nextInt(size * 2); // Generate random numbers
            }
            Arrays.sort(arr); // Binary search requires a sorted array

            int target = random.nextInt(size * 2);
            long startTime = System.nanoTime();
            binarySearch(arr, target);
            long endTime = System.nanoTime();

            long executionTime = endTime - startTime;


            Files.writeString(tempFile, "Array size: " + size + ", Execution time: " + executionTime + " ns\n");
        }

        System.out.println("Execution times written to: " + tempFile.toAbsolutePath());

    }
}