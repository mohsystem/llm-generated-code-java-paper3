package Vanilla.openai;
import java.util.Arrays;

public class Task155 {

    public int[] heapSort(int[] array) {
        int n = array.length;

        // Build max heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(array, n, i);
        }

        // Extract elements from heap
        for (int i = n - 1; i > 0; i--) {
            // Swap current root to end
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;

            // Call max heapify on the reduced heap
            heapify(array, i, 0);
        }

        return array;
    }

    void heapify(int[] array, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && array[left] > array[largest]) {
            largest = left;
        }

        if (right < n && array[right] > array[largest]) {
            largest = right;
        }

        if (largest != i) {
            int swap = array[i];
            array[i] = array[largest];
            array[largest] = swap;

            heapify(array, n, largest);
        }
    }

    public static void main(String[] args) {
        Task155 sorter = new Task155();
        int[][] testCases = {
            {12, 11, 13, 5, 6, 7},
            {4, 10, 3, 5, 1},
            {1, 2, 3, 4, 5},
            {9, 8, 7, 6, 5},
            {0, -1, 3, -10, 5}
        };

        for (int[] testCase : testCases) {
            System.out.println(Arrays.toString(sorter.heapSort(testCase)));
        }
    }
}