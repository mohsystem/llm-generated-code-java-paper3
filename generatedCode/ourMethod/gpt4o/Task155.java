package ourMethod.openai;
public class Task155 {

    public static void heapSort(int[] array) {
        int n = array.length;

        // Build heap (rearrange array)
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(array, n, i);

        // One by one extract an element from heap
        for (int i = n - 1; i >= 0; i--) {
            // Move current root to end
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;

            // call max heapify on the reduced heap
            heapify(array, i, 0);
        }
    }

    private static void heapify(int[] array, int n, int i) {
        int largest = i; // Initialize largest as root
        int left = 2 * i + 1; // left = 2*i + 1
        int right = 2 * i + 2; // right = 2*i + 2

        // If left child is larger than root
        if (left < n && array[left] > array[largest])
            largest = left;

        // If right child is larger than largest so far
        if (right < n && array[right] > array[largest])
            largest = right;

        // If largest is not root
        if (largest != i) {
            int swap = array[i];
            array[i] = array[largest];
            array[largest] = swap;

            // Recursively heapify the affected sub-tree
            heapify(array, n, largest);
        }
    }

    public static void main(String[] args) {
        int[][] testCases = {
            {4, 10, 3, 5, 1},
            {12, 11, 13, 5, 6, 7},
            {1, 2, 3, 4, 5},
            {5, 4, 3, 2, 1},
            {10, 20, 15, 30, 40}
        };

        for (int[] testCase : testCases) {
            heapSort(testCase);
            for (int num : testCase) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}