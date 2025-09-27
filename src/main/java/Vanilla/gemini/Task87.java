package Vanilla.gemini;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

class Task87 {
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

        return -1; // Target not found
    }

    public static void main(String[] args) throws IOException {
        int[] testCases = {10, 100, 1000, 10000, 100000};

        for (int size : testCases) {
            int[] arr = new int[size];
            Random random = new Random();
            for (int i = 0; i < size; i++) {
                arr[i] = random.nextInt(size * 2); // Generate random numbers up to twice the size
            }
            Arrays.sort(arr); // Binary search requires a sorted array
            int target = random.nextInt(size * 2);

            long startTime = System.nanoTime();
            binarySearch(arr, target);
            long endTime = System.nanoTime();
            long executionTime = endTime - startTime;

            try (FileWriter writer = new FileWriter("temp.txt", true)) {
                writer.write("Execution time for array size " + size + ": " + executionTime + " nanoseconds\n");
            }
        }
    }
}