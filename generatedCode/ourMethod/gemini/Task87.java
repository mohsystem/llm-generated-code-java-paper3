package ourMethod.gemini;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;

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
        int[][] testCases = {
                {2, 5, 7, 8, 11, 12},
                {2, 5, 7, 8, 11, 12},
                {1, 2, 3, 4, 5, 6},
                {1, 5},
                {}
        };
        int[] targets = {12, 13, 4, 1, 5};

        for (int i = 0; i < testCases.length; i++) {
            int[] arr = testCases[i];
            Arrays.sort(arr); // Ensure the array is sorted
            int target = targets[i];


            Instant start = Instant.now();
            int result = binarySearch(arr, target);
            Instant end = Instant.now();
            Duration timeElapsed = Duration.between(start, end);

            Path tempFilePath = Files.createTempFile("binary_search_execution_time_", ".txt");
            Files.writeString(tempFilePath, "Execution time: " + timeElapsed.toNanos() + " nanoseconds\n");

            System.out.println("Test case " + (i + 1) + ": Target " + target + " found at index: " + result);
            System.out.println("Execution time written to: " + tempFilePath);


        }

    }
}