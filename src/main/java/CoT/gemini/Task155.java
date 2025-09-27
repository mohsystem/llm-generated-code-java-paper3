package CoT.gemini;
import java.util.Arrays;

public class Task155 {

    public static void heapSort(int[] arr) {
        int n = arr.length;

        // Build max heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        // Heap sort
        for (int i = n - 1; i >= 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapify(arr, i, 0);
        }
    }

    static void heapify(int[] arr, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }

        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }

        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            heapify(arr, n, largest);
        }
    }

    public static void main(String[] args) {
        int[] arr1 = {5, 1, 4, 2, 8};
        heapSort(arr1);
        System.out.println(Arrays.toString(arr1)); // Expected: [1, 2, 4, 5, 8]

        int[] arr2 = {3, 7, 9, 1, 5};
        heapSort(arr2);
        System.out.println(Arrays.toString(arr2)); // Expected: [1, 3, 5, 7, 9]

        int[] arr3 = {12, 11, 13, 5, 6, 7};
        heapSort(arr3);
        System.out.println(Arrays.toString(arr3)); // Expected: [5, 6, 7, 11, 12, 13]

        int[] arr4 = {};
        heapSort(arr4);
        System.out.println(Arrays.toString(arr4)); // Expected: []

        int[] arr5 = {5};
        heapSort(arr5);
        System.out.println(Arrays.toString(arr5)); // Expected: [5]

    }
}