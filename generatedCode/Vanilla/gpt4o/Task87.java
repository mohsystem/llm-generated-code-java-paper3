package Vanilla.gpt4o;
import java.io.FileWriter;
import java.io.IOException;

public class Task87 {

    public static int binarySearch(int[] array, int target) {
        int low = 0, high = array.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (array[mid] == target) {
                return mid;
            } else if (array[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        int[] targets = {5, 1, 10, 0, 8};

        for (int target : targets) {
            long startTime = System.nanoTime();
            int result = binarySearch(array, target);
            long endTime = System.nanoTime();
            long duration = endTime - startTime;

            try (FileWriter writer = new FileWriter("temp_java.txt", true)) {
                writer.write("Target: " + target + ", Result: " + result + ", Duration: " + duration + " ns\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}