package ourMethod.gemini;
import java.util.Arrays;

public class Task155 {

    public static void heapSort(int[] arr) {
        int n = arr.length;

        // Build max heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        // Extract elements from heap one by one
        for (int i = n - 1; i > 0; i--) {
            // Move current root to end
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // Heapify reduced heap
            heapify(arr, i, 0);
        }
    }

    private static void heapify(int[] arr, int n, int i) {
        int largest = i; // Initialize largest as root
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        // If left child is larger than root
        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }

        // If right child is larger than largest so far
        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }

        // If largest is not root
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            // Recursively heapify the affected sub-tree
            heapify(arr, n, largest);
        }
    }

    public static void main(String[] args) {
        int[] arr1 = {12, 11, 13, 5, 6, 7};
        heapSort(arr1);
        System.out.println(Arrays.toString(arr1));

        int[] arr2 = {5, 1, 4, 2, 8};
        heapSort(arr2);
        System.out.println(Arrays.toString(arr2));

        int[] arr3 = {3, 1, 4, 1, 5, 9, 2, 6};
        heapSort(arr3);
        System.out.println(Arrays.toString(arr3));

        int[] arr4 = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        heapSort(arr4);
        System.out.println(Arrays.toString(arr4));

        int[] arr5 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        heapSort(arr5);
        System.out.println(Arrays.toString(arr5));
    }
}