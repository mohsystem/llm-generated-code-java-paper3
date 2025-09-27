package ZeroShot.gemini;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;

class Task87 {
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


    public static void main(String[] args) throws IOException {
        int[] testCases = {5, 10, 100, 1000, 10000};

        for (int n : testCases) {
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = i * 2;
            }
            int target = (int) (Math.random() * n * 2);

            Instant start = Instant.now();
            int result = binarySearch(arr, target);
            Instant end = Instant.now();

            Duration duration = Duration.between(start, end);

            File tempFile = File.createTempFile("binary_search_timing", ".txt");
            Files.writeString(tempFile.toPath(), String.valueOf(duration.toNanos()));

            System.out.println("Test case with " + n + " elements, Target:" + target + " , Result index: " + result + ", Time:" + duration.toNanos() + "ns, Output file: " + tempFile.getAbsolutePath());
        }
    }
}