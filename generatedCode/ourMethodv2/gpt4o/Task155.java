package ourMethodv2.gpt4o;
import java.util.Arrays;

public class Task155 {
    public void heapSort(int[] arr) {
        int n = arr.length;

        // Build heap (rearrange array)
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        // One by one extract an element from heap
        for (int i = n - 1; i > 0; i--) {
            // Move current root to end
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // call max heapify on the reduced heap
            heapify(arr, i, 0);
        }
    }

    // To heapify a subtree rooted with node i which is an index in arr[]. n is size of heap
    void heapify(int[] arr, int n, int i) {
        int largest = i;  // Initialize largest as root
        int left = 2 * i + 1;  // left = 2*i + 1
        int right = 2 * i + 2;  // right = 2*i + 2

        // If left child is larger than root
        if (left < n && arr[left] > arr[largest])
            largest = left;

        // If right child is larger than largest so far
        if (right < n && arr[right] > arr[largest])
            largest = right;

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
        Task155 task = new Task155();
        int[][] testCases = {
            {4, 10, 3, 5, 1},
            {12, 11, 13, 5, 6, 7},
            {1, 2, 3, 4, 5, 6},
            {9, 8, 7, 6, 5, 4, 3, 2, 1},
            {5, 12, 11, 13, 5, 6, 7}
        };
        
        for (int[] testCase : testCases) {
            task.heapSort(testCase);
            System.out.println(Arrays.toString(testCase));
        }
    }
}